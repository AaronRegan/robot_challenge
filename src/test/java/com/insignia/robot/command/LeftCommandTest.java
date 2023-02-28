package com.insignia.robot.command;

import com.insignia.robot.model.Direction;
import com.insignia.robot.model.Robot;
import com.insignia.robot.model.Table;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeftCommandTest {

    private Robot robot;
    private Table table;
    private Command command;

    @Before
    public void setUp() {
        robot = new Robot(0,0, 0, Direction.NORTH);
        table = new Table(5, 5);
        table.addRobot(robot);
        command = new LeftCommand(robot, table);
    }

    @Test
    public void testExecute() {
        command.execute();
        Assert.assertEquals(Direction.WEST, robot.getDirection());
        command.execute();
        Assert.assertEquals(Direction.SOUTH, robot.getDirection());
        command.execute();
        Assert.assertEquals(Direction.EAST, robot.getDirection());
        command.execute();
        Assert.assertEquals(Direction.NORTH, robot.getDirection());
    }
}
