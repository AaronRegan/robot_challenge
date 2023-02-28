package com.insignia.robot.command;

import com.insignia.robot.model.Robot;
import com.insignia.robot.model.Table;

public class MoveCommand implements Command {

    private Robot activeRobot;
    private Table table;

    public MoveCommand(Robot activeRobot, Table table) {
        this.activeRobot = activeRobot;
        this.table = table;
    }

    @Override
    public void execute() {
        if (activeRobot == null || table == null) {
            return;
        }

        int currentX = activeRobot.getX();
        int currentY = activeRobot.getY();
        int newX = currentX;
        int newY = currentY;

        switch (activeRobot.getDirection()) {
            case NORTH:
                newY++;
                break;
            case EAST:
                newX++;
                break;
            case SOUTH:
                newY--;
                break;
            case WEST:
                newX--;
                break;
            default:
                break;
        }

        if (table.isValidPosition(newX, newY)) {
            activeRobot.setX(newX);
            activeRobot.setY(newY);
        }
    }
}
