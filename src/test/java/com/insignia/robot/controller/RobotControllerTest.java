package com.insignia.robot.controller;

import com.insignia.robot.model.Direction;
import com.insignia.robot.model.Robot;
import com.insignia.robot.model.Table;
import com.insignia.robot.service.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class RobotControllerTest {

    private RobotController robotController;
    private Table table;

    @Before
    public void setUp() {
        robotController = new RobotController();
        table = new Table(5, 5);
    }

    @Test
    public void testPlaceRobot() {
        robotController.placeRobot(0, 0, Direction.NORTH, table);
        assertEquals(Direction.NORTH, robotController.activateRobot(1, table).get().getDirection());
    }

    @Test
    public void testMoveActiveRobot() {
        robotController.placeRobot(0, 0, Direction.NORTH, table);
        robotController.moveActiveRobot(table);
        Robot activeRobot = robotController.getActiveRobot();
        assertNotNull(activeRobot);
        assertEquals(0, activeRobot.getX());
        assertEquals(1, activeRobot.getY());
    }

    @Test
    public void testTurnActiveRobotLeft() {
        robotController.placeRobot(0, 0, Direction.NORTH, table);
        robotController.turnActiveRobotLeft(table);
        Robot activeRobot = robotController.getActiveRobot();
        assertNotNull(activeRobot);
        assertEquals(Direction.WEST, activeRobot.getDirection());
    }

    @Test
    public void testTurnActiveRobotRight() {
        robotController.placeRobot(0, 0, Direction.NORTH, table);
        robotController.turnActiveRobotRight(table);
        Robot activeRobot = robotController.getActiveRobot();
        assertNotNull(activeRobot);
        assertEquals(Direction.EAST, activeRobot.getDirection());
    }

    @Test
    public void testReportActiveRobot() {
        robotController.placeRobot(0, 0, Direction.NORTH, table);
        robotController.reportActiveRobot(table);
        assertEquals(Direction.NORTH, robotController.activateRobot(1, table).get().getDirection());
    }

    @Test
    public void testActivateRobot() {
        robotController.placeRobot(0, 0, Direction.NORTH, table);
        Optional<Robot> activateRobotResult = robotController.activateRobot(1, table);
        assertTrue(activateRobotResult.isPresent());
        assertEquals(Direction.NORTH, activateRobotResult.get().getDirection());
    }

    @Test
    public void testActivateInvalidRobot() {
        robotController.placeRobot(0, 0, Direction.NORTH, table);
        Optional<Robot> activateRobotResult = robotController.activateRobot(2, table);
        assertFalse(activateRobotResult.isPresent());
    }
}
