import java.util.Scanner;

public class ToyRobot {
    private int x;
    private int y;
    private String direction;

    public ToyRobot() {
        this.x = -1;
        this.y = -1;
        this.direction = null;
    }

    // Places the robot on the table if it's a valid position
    public boolean place(int x, int y, String direction) {
        if (x < 0 || x > 4 || y < 0 || y > 4) {
            return false;
        }

        this.x = x;
        this.y = y;
        this.direction = direction;
        return true;
    }

    // Moves the robot one step in the current direction
    public void move() {
        if (direction == null) {
            return;
        }

        int dx = 0;
        int dy = 0;

        switch (direction) {
            case "NORTH":
                dy = 1;
                break;
            case "SOUTH":
                dy = -1;
                break;
            case "EAST":
                dx = 1;
                break;
            case "WEST":
                dx = -1;
                break;
        }

        int newX = x + dx;
        int newY = y + dy;

        if (newX < 0 || newX > 4 || newY < 0 || newY > 4) {
            return;
        }

        x = newX;
        y = newY;
    }

    // Turns the robot 90 degrees to the left
    public void left() {
        if (direction == null) {
            return;
        }

        switch (direction) {
            case "NORTH":
                direction = "WEST";
                break;
            case "SOUTH":
                direction = "EAST";
                break;
            case "EAST":
                direction = "NORTH";
                break;
            case "WEST":
                direction = "SOUTH";
                break;
        }
    }

    // Turns the robot 90 degrees to the right
    public void right() {
        if (direction == null) {
            return;
        }

        switch (direction) {
            case "NORTH":
                direction = "EAST";
                break;
            case "SOUTH":
                direction = "WEST";
                break;
            case "EAST":
                direction = "SOUTH";
                break;
            case "WEST":
                direction = "NORTH";
                break;
        }
    }

    // Returns a string with the robot's current position and direction
    public String report() {
        if (direction == null) {
            return "";
        }

        return x + "," + y + "," + direction;
    }

    public static void main(String[] args) {
        ToyRobot robot = new ToyRobot();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            String command = tokens[0];

            switch (command) {
                case "PLACE":
                    String[] params = tokens[1].split(",");
                    int x = Integer.parseInt(params[0]);
                    int y = Integer.parseInt(params[1]);
                    String direction = params[2];
                    robot.place(x, y, direction);
                    break;
                case "MOVE":
                    robot.move();
                    break;
                case "LEFT":
                    robot.left();
                    break;
                case "RIGHT":
                    robot.right();
                    break;
                case "REPORT":
                    System.out.println(robot.report());
                    break;
            }
        }
    }
}
