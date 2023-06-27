package martianRobots;

public class RobotController {

    private static final char[] ORIENTATIONS = {'N', 'E', 'S', 'W'};
    private static final int MAX_COORDINATE_SIZE = 50;

    /**
     * Moves the robot based on the provided instructions within the given grid.
     *
     * @param robot        The robot object to move.
     * @param instructions The string containing the instructions for the robot's movement.
     * @param grid         The grid on which the robot is moving.
     * @return A string representing the final position and orientation of the robot.
     * If the robot goes off the grid and is lost, the string will indicate
     * the lost status as well.
     */
    public String move(Robot robot, String instructions, Grid grid) {
        String errors = validateInput(grid, robot);
        if (errors != null) {
            return errors;
        }

        for (char instruction : instructions.toCharArray()) {
            if (instruction == 'F') {
                int newX = robot.getxCoord() + (robot.getOrientation() == 'E' ? 1 : (robot.getOrientation() == 'W' ? -1 : 0));
                int newY = robot.getyCoord() + (robot.getOrientation() == 'N' ? 1 : (robot.getOrientation() == 'S' ? -1 : 0));

                if (grid.isOffGrid(newX, newY)) {
                    if (!grid.hasScentMark(robot.getxCoord(), robot.getyCoord())) {
                        grid.addScentMark(robot.getxCoord(), robot.getyCoord());
                        return robot.getxCoord() + " " + robot.getyCoord() + " " + robot.getOrientation() + " LOST";
                    }
                } else {
                    robot.setxCoord(newX);
                    robot.setyCoord(newY);
                }
            } else if (instruction == 'R' || instruction == 'L') {
                robot.setOrientation(turnRobot(instruction, robot.getOrientation()));
            }
        }


        return robot.getxCoord() + " " + robot.getyCoord() + " " + robot.getOrientation();
    }


    /**
     * Turns the robot in the specified direction based on its current orientation.
     *
     * @param direction           the direction to turn the robot ('L' for left, 'R' for right)
     * @param startingOrientation the current orientation of the robot
     * @return the new orientation of the robot after turning
     */
    private char turnRobot(char direction, char startingOrientation) {
        int currentIndex = getIndex(startingOrientation);

        if (direction == 'L') {
            currentIndex = (currentIndex + 3) % 4;
        } else if (direction == 'R') {
            currentIndex = (currentIndex + 1) % 4;
        }

        return ORIENTATIONS[currentIndex];
    }

    /**
     * Retrieves the index of the specified orientation in the ORIENTATIONS array.
     *
     * @param orientation the orientation to find the index of
     * @return the index of the orientation in the ORIENTATIONS array, or -1 if not found
     */
    private int getIndex(char orientation) {
        for (int i = 0; i < ORIENTATIONS.length; i++) {
            if (ORIENTATIONS[i] == orientation) {
                return i;
            }
        }
        return -1;
    }

    private String validateInput(Grid grid, Robot robot) {
        if (grid.getMaxX() > MAX_COORDINATE_SIZE || grid.getMaxY() > MAX_COORDINATE_SIZE || grid.getMaxX() < 0 || grid.getMaxY() < 0) {
            return "Grid has an invalid size - max coordinate size: " + MAX_COORDINATE_SIZE + " min coordinate size : 0. Entered X coordinate size: " + grid.getMaxX() + " Entered Y coordinate size: " + grid.getMaxY();
        }

        if (robot.getxCoord() > MAX_COORDINATE_SIZE || robot.getxCoord() < 0 || robot.getyCoord() > MAX_COORDINATE_SIZE || robot.getyCoord() < 0) {
            return "Robot is in an invalid coordinate - robot X coord: " + robot.getyCoord() + " Robot Y coord: " + robot.getyCoord();
        }

        if (robot.getxCoord() > grid.getMaxX() || robot.getyCoord() > grid.getMaxY()) {
            return "Robot initial coordinate is over the maximum size of the grid";
        }
        return null;
    }
}
