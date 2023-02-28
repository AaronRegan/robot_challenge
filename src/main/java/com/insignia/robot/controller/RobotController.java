package com.insignia.robot.controller;

import com.insignia.robot.model.Direction;
import com.insignia.robot.model.Robot;
import com.insignia.robot.model.Table;
import com.insignia.robot.command.*;

import java.util.List;
import java.util.Optional;

public class RobotController {
    private List<Robot> robots;
    private Robot activeRobot;

    public void placeRobot(int x, int y, Direction direction, Table table) {
        robots = table.getRobots();
        Robot robot = new Robot( robots.size() + 1, x, y, direction);
        robots.add(robot);
        activateRobot(robot);
    }

    public void moveActiveRobot(Table table) {
        if (activeRobot != null) {
            Command moveCommand = new MoveCommand(activeRobot, table);
            moveCommand.execute();
        }
    }

    public void turnActiveRobotLeft(Table table) {
        if (activeRobot != null) {
            Command leftCommand = new LeftCommand(activeRobot, table);
            leftCommand.execute();
        }
    }

    public void turnActiveRobotRight(Table table) {
        if (activeRobot != null) {
            Command rightCommand = new RightCommand(activeRobot, table);
            rightCommand.execute();
        }
    }

    public void reportActiveRobot(Table table) {
        if (activeRobot != null) {
            Command reportCommand = new ReportCommand(activeRobot, table);
            reportCommand.execute();
        } else {
            System.out.println("No Active Robots");
        }
    }

    public Optional<Robot> activateRobot(int robotId, Table table) {
        Optional<Robot> optionalRobot = table.getRobots().stream().filter(r -> r.getId() == robotId).findFirst();
        return optionalRobot.map(this::activateRobot);
    }

    public Robot getActiveRobot() { return activeRobot; }

    private Robot activateRobot(Robot robot) {
        return activeRobot = robot;
    }
}
