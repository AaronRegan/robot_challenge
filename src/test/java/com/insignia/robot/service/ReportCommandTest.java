package com.insignia.robot.service;

import com.insignia.robot.model.Direction;
import com.insignia.robot.model.Robot;
import com.insignia.robot.model.Table;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ReportCommandTest {

    private Robot robot;
    private Table table;
    private Command command;

    @Before
    public void setUp() {
        robot = new Robot(0, 0, 0, Direction.NORTH);
        table = new Table(5, 5);
        table.addRobot(robot);
        command = new ReportCommand(robot, table);
    }

    @Test
    public void testExecute() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        command.execute();
        String expectedOutput = String.format("Robot %d of %d: %d,%d,%s",
                robot.getId(), table.getRobots().size(), robot.getX(), robot.getY(), robot.getDirection().toString());
        Assert.assertEquals(expectedOutput, outContent.toString());
    }
}
