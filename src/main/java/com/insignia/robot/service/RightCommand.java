package com.insignia.robot.service;

import com.insignia.robot.model.Direction;
import com.insignia.robot.model.Robot;
import com.insignia.robot.model.Table;

public class RightCommand implements Command {

    private Robot activeRobot;
    private Table table;

    public RightCommand(Robot activeRobot, Table table) {
        this.activeRobot = activeRobot;
        this.table = table;
    }

    @Override
    public void execute() {
        Direction direction = activeRobot.getDirection();
        switch (direction) {
            case NORTH:
                activeRobot.setDirection(Direction.EAST);
                break;
            case EAST:
                activeRobot.setDirection(Direction.SOUTH);
                break;
            case SOUTH:
                activeRobot.setDirection(Direction.WEST);
                break;
            case WEST:
                activeRobot.setDirection(Direction.NORTH);
                break;
        }
    }
}
