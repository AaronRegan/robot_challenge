package com.insignia.robot.command;

import com.insignia.robot.model.Direction;
import com.insignia.robot.model.Robot;
import com.insignia.robot.model.Table;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RightCommandTest {

    private Table table;
    private Robot activeRobot;
    private RightCommand rightCommand;

    @Before
    public void setUp() {
        table = new Table(5, 5);
        activeRobot = new Robot(1,1, 1, Direction.NORTH);
        table.addRobot(activeRobot);
        rightCommand = new RightCommand(activeRobot);
    }

    @Test
    public void testExecute() {
        rightCommand.execute();
        assertEquals(Direction.EAST, activeRobot.getDirection());
        rightCommand.execute();
        assertEquals(Direction.SOUTH, activeRobot.getDirection());
        rightCommand.execute();
        assertEquals(Direction.WEST, activeRobot.getDirection());
        rightCommand.execute();
        assertEquals(Direction.NORTH, activeRobot.getDirection());
    }
}
