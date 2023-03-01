package com.insignia.robot;

import com.insignia.robot.controller.RobotController;
import com.insignia.robot.exception.InvalidCommandException;
import com.insignia.robot.model.Commands;
import com.insignia.robot.model.Direction;
import com.insignia.robot.model.Table;

import java.util.Scanner;

public class Main {

    private static final int BOARD_SIZE_X = 5;
    private static final int BOARD_SIZE_Y = 5;

    public static void main(String[] args) {
            Table table = new Table(BOARD_SIZE_X, BOARD_SIZE_Y);
            RobotController robotController = new RobotController();

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine();
                String[] tokens = input.split(" ");
                String command = tokens[0].toUpperCase();
                try {
                    Commands cmd = Commands.valueOf(command);
                    switch (cmd) {
                        case PLACE:
                            if (tokens.length < 2) {
                                throw new InvalidCommandException("Invalid command: " + input);
                            }
                            String[] argsPlace = tokens[1].split(",");
                            if (argsPlace.length != 3) {
                                throw new InvalidCommandException("Invalid command: " + input);
                            }
                            int x = Integer.parseInt(argsPlace[0]);
                            int y = Integer.parseInt(argsPlace[1]);
                            Direction direction = Direction.valueOf(argsPlace[2]);
                            robotController.placeRobot(x, y, direction, table);
                            break;
                        case MOVE:
                            robotController.moveActiveRobot(table);
                            break;
                        case LEFT:
                            robotController.turnActiveRobotLeft();
                            break;
                        case RIGHT:
                            robotController.turnActiveRobotRight();
                            break;
                        case REPORT:
                            robotController.reportActiveRobot(table);
                            break;
                        case ROBOT:
                            if (tokens.length < 2) {
                                throw new InvalidCommandException("Invalid command: " + input);
                            }
                            int robotNumber = Integer.parseInt(tokens[1]);
                            robotController.activateRobot(robotNumber, table);
                            break;
                        case EXIT:
                            scanner.close();
                            return;
                    }
                } catch (IllegalArgumentException ex) {
                    System.out.println("Invalid command: " + input);
                } catch (InvalidCommandException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
}
