import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxX = scanner.nextInt();
        int maxY = scanner.nextInt();
        scanner.nextLine();

        Grid grid = new Grid(maxX, maxY);

        while (scanner.hasNextLine()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char orientation = scanner.next().charAt(0);
            scanner.nextLine();
            String instructions = scanner.nextLine();

            Robot robot = new Robot(x, y, orientation);
            RobotController robotController = new RobotController();
            System.out.println(robotController.move(robot, instructions, grid));
        }

        scanner.close();
    }
}