package com.insignia.robot.model;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int width;
    private final int height;
    private final List<Robot> robots;
    private Robot activeRobot;

    public Table(int width, int height) {
        this.width = width;
        this.height = height;
        this.robots = new ArrayList<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void addRobot(Robot robot) {
        robots.add(robot);
        if (activeRobot == null) {
            setActiveRobot(robot);
        }
    }

    public void setActiveRobot(Robot robot) {
        if (!robots.contains(robot)) {
            throw new IllegalArgumentException("Robot not on table");
        }
        activeRobot = robot;
    }

    public Robot getActiveRobot() {
        return activeRobot;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
