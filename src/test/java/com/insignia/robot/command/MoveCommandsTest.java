package com.insignia.robot.command;

import com.insignia.robot.model.Direction;
import com.insignia.robot.model.Robot;
import com.insignia.robot.model.Table;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoveCommandsTest {

    private Robot robot;
    private Table table;
    private Command command;

    @Before
    public void setUp() {
        robot = new Robot(0,0, 0, Direction.NORTH);
        table = new Table(5, 5);
        table.addRobot(robot);
        command = new MoveCommand(robot, table);
    }

    @Test
    public void testExecute_validMove() {
        command.execute();
        Assert.assertEquals(0, robot.getX());
        Assert.assertEquals(1, robot.getY());
    }

    @Test
    public void testExecute_invalidMove() {
        robot.setDirection(Direction.SOUTH);
        command.execute();
        Assert.assertEquals(0, robot.getX());
        Assert.assertEquals(0, robot.getY());
    }

    @Test
    public void testExecute_nullRobot() {
        command = new MoveCommand(null, table);
        command.execute();
        Assert.assertEquals(0, robot.getX());
        Assert.assertEquals(0, robot.getY());
    }

    @Test
    public void testExecute_nullTable() {
        command = new MoveCommand(robot, null);
        command.execute();
        Assert.assertEquals(0, robot.getX());
        Assert.assertEquals(0, robot.getY());
    }
}
