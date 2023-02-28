package com.insignia.robot;

import com.insignia.robot.controller.RobotController;
import com.insignia.robot.model.Direction;
import com.insignia.robot.model.Table;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            Table table = new Table(5, 5);
            RobotController robotController = new RobotController();

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine();
                String[] tokens = input.split(" ");
                String command = tokens[0];

                if (command.equalsIgnoreCase("PLACE")) {
                    if (tokens.length < 2) {
                        System.out.println("Invalid command: " + input);
                        continue;
                    }
                    String[] argsPlace = tokens[1].split(",");
                    if (argsPlace.length != 3) {
                        System.out.println("Invalid command: " + input);
                        continue;
                    }
                    int x = Integer.parseInt(argsPlace[0]);
                    int y = Integer.parseInt(argsPlace[1]);
                    Direction direction = Direction.valueOf(argsPlace[2]);
                    robotController.placeRobot(x, y, direction, table);
                } else if (command.equalsIgnoreCase("MOVE")) {
                    robotController.moveActiveRobot(table);
                } else if (command.equalsIgnoreCase("LEFT")) {
                    robotController.turnActiveRobotLeft(table);
                } else if (command.equalsIgnoreCase("RIGHT")) {
                    robotController.turnActiveRobotRight(table);
                } else if (command.equalsIgnoreCase("REPORT")) {
                    robotController.reportActiveRobot(table);
                } else if (command.equalsIgnoreCase("ROBOT")) {
                    if (tokens.length < 2) {
                        System.out.println("Invalid command: " + input);
                        continue;
                    }
                    int robotNumber = Integer.parseInt(tokens[1]);
                   robotController.activateRobot(robotNumber, table);
                } else if (command.equalsIgnoreCase("EXIT")) {
                    break;
                } else {
                    System.out.println("Invalid command: " + input);
                }
            }

            scanner.close();
        }
}
