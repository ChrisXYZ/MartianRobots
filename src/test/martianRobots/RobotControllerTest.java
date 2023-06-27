package martianRobots;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class RobotControllerTest {
    public RobotController robotController;
    public Robot robot;
    public Grid grid;

    @BeforeEach
    public void setup() {
        robotController = new RobotController();
        grid = new Grid(5, 3);
    }

    @Test
    public void sampleInputTest() {
        robot = new Robot(1, 1, 'E');
        String instructions = "RFRFRFRF";
        String expected = "1 1 E";
        String result = robotController.move(robot, instructions, grid);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void lostRobotTest() {
        robot = new Robot(3, 2, 'N');
        String instructions = "FRRFLLFFRRFLL";
        String expected = "3 3 N LOST";
        String result = robotController.move(robot, instructions, grid);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void withoutScentMarkTest() {
        robot = new Robot(0, 3, 'W');
        String instructions = "LLFFFLFLFL";
        String expected = "3 3 N LOST";
        String result = robotController.move(robot, instructions, grid);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void withScentMarkTest() {
        String instructions = "FRRFLLFFRRFLL";
        robot = new Robot(3, 2, 'N');
        String expected = "3 3 N LOST";
        String result = robotController.move(robot, instructions, grid);
        Assertions.assertEquals(expected, result);


        robot = new Robot(0, 3, 'W');
        instructions = "LLFFFLFLFL";
        expected = "2 3 S";
        result = robotController.move(robot, instructions, grid);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void GridSizeToLargeTest() {
        robot = new Robot(3, 2, 'N');
        grid = new Grid(51, 51);
        String instructions = "FRRFLLFFRRFLL";
        String expected = "Grid has an invalid size - max coordinate size: 50 min coordinate size : 0. Entered X coordinate size: 51 Entered Y coordinate size: 51";
        String result = robotController.move(robot, instructions, grid);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void GridSizeToSmallTest() {
        robot = new Robot(3, 2, 'N');
        grid = new Grid(-1, -1);
        String instructions = "FRRFLLFFRRFLL";
        String expected = "Grid has an invalid size - max coordinate size: 50 min coordinate size : 0. Entered X coordinate size: -1 Entered Y coordinate size: -1";
        String result = robotController.move(robot, instructions, grid);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void RobotInitialCoordinatesInvalidTest() {
        robot = new Robot(-1, -1, 'N');
        grid = new Grid(20, 20);
        String instructions = "FRRFLLFFRRFLL";
        String expected = "Robot is in an invalid coordinate - robot X coord: -1 Robot Y coord: -1";
        String result = robotController.move(robot, instructions, grid);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void RobotMaxInitialCoordinatesInvalidTest() {
        robot = new Robot(500, 500, 'N');
        grid = new Grid(20, 20);
        String instructions = "FRRFLLFFRRFLL";
        String expected = "Robot is in an invalid coordinate - robot X coord: 500 Robot Y coord: 500";
        String result = robotController.move(robot, instructions, grid);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void RobotInInvalidCoordinate() {
        robot = new Robot(21, 21, 'N');
        grid = new Grid(20, 20);
        String instructions = "FRRFLLFFRRFLL";
        String expected = "Robot initial coordinate is over the maximum size of the grid";
        String result = robotController.move(robot, instructions, grid);
        Assertions.assertEquals(expected, result);
    }
}
