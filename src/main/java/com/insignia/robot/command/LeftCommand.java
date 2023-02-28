package com.insignia.robot.command;

import com.insignia.robot.model.Direction;
import com.insignia.robot.model.Robot;
import com.insignia.robot.model.Table;

public class LeftCommand implements Command {

    private Robot activeRobot;

    public LeftCommand(Robot activeRobot) {
        this.activeRobot = activeRobot;
    }

    @Override
    public void execute() {
        Direction direction = activeRobot.getDirection();
        switch (direction) {
            case NORTH:
                activeRobot.setDirection(Direction.WEST);
                break;
            case EAST:
                activeRobot.setDirection(Direction.NORTH);
                break;
            case SOUTH:
                activeRobot.setDirection(Direction.EAST);
                break;
            case WEST:
                activeRobot.setDirection(Direction.SOUTH);
                break;
        }
    }
}
