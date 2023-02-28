package com.insignia.robot.command;

import com.insignia.robot.model.Direction;
import com.insignia.robot.model.Robot;
import com.insignia.robot.model.Table;

public class ReportCommand implements Command {

    private final Robot activeRobot;
    private final Table table;

    public ReportCommand(Robot activeRobot, Table table) {
        this.activeRobot = activeRobot;
        this.table = table;
    }

    @Override
    public void execute() {
        if (activeRobot != null) {
            int robotCount = table.getRobots().size();
            int robotId = activeRobot.getId();
            int x = activeRobot.getX();
            int y = activeRobot.getY();
            Direction direction = activeRobot.getDirection();
            System.out.printf("Robot %d of %d: %d,%d,%s \n",
                    robotId, robotCount, x, y, direction.toString());
        }
    }
}
