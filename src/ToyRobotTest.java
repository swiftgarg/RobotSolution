import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ToyRobotTest {

    private static final String NORTH = "NORTH";
    private static final String SOUTH = "SOUTH";
    private static final String EAST = "EAST";
    private static final String WEST = "WEST";

    ToyRobot robot = new ToyRobot();

    @Test
    public void testPlace() {
        ToyRobot robot = new ToyRobot();

        // Test placing within bounds
        boolean result1 = robot.place(2, 3, "NORTH");
        assertEquals(true, result1);
        assertEquals("2,3,NORTH", robot.report());

        // Test placing off the table
        boolean result2 = robot.place(5, 1, "WEST");
        assertEquals(false, result2);
        assertEquals("2,3,NORTH", robot.report());
    }

    @Test
    public void testMove() {
        ToyRobot robot = new ToyRobot();

        // Test moving within bounds
        robot.place(1, 2, "EAST");
        robot.move();
        assertEquals("2,2,EAST", robot.report());

        // Test moving off the edge
        robot.place(4, 0, "NORTH");
        robot.move();
        assertEquals("4,1,NORTH", robot.report());
        robot.move();
        assertEquals("4,2,NORTH", robot.report());
        robot.move();
        assertEquals("4,3,NORTH", robot.report());
        robot.move();
        assertEquals("4,4,NORTH", robot.report());
        robot.move();
        assertEquals("4,4,NORTH", robot.report());
    }

    @Test
    public void testLeft() {
        ToyRobot robot = new ToyRobot();

        // Test turning left from different directions
        robot.place(2, 2, "NORTH");
        robot.left();
        assertEquals("2,2,WEST", robot.report());
        robot.left();
        assertEquals("2,2,SOUTH", robot.report());
        robot.left();
        assertEquals("2,2,EAST", robot.report());
        robot.left();
        assertEquals("2,2,NORTH", robot.report());
    }

    @Test
    public void testRight() {
        ToyRobot robot = new ToyRobot();

        // Test turning right from different directions
        robot.place(2, 2, "WEST");
        robot.right();
        assertEquals("2,2,NORTH", robot.report());
        robot.right();
        assertEquals("2,2,EAST", robot.report());
        robot.right();
        assertEquals("2,2,SOUTH", robot.report());
        robot.right();
        assertEquals("2,2,WEST", robot.report());
    }

    @Test
    public void testMoveNorthEdge() {
        robot.place(0, 4, NORTH);
        robot.move();
        assertEquals("0,4,NORTH", robot.report());
    }

    @Test
    public void testMoveSouthEdge() {
        robot.place(0, 0, SOUTH);
        robot.move();
        assertEquals("0,0,SOUTH", robot.report());
    }

    @Test
    public void testMoveEastEdge() {
        robot.place(4, 0, EAST);
        robot.move();
        assertEquals("4,0,EAST", robot.report());
    }

    @Test
    public void testMoveWestEdge() {
        robot.place(0, 0, WEST);
        robot.move();
        assertEquals("0,0,WEST", robot.report());
    }

    @Test
    public void testMoveOffNorthEdge() {
        robot.place(0, 4, NORTH);
        robot.move();
        robot.move();
        assertEquals("0,4,NORTH", robot.report());
    }

    @Test
    public void testMoveOffSouthEdge() {
        robot.place(0, 0, SOUTH);
        robot.move();
        robot.move();
        assertEquals("0,0,SOUTH", robot.report());
    }

    @Test
    public void testMoveOffEastEdge() {
        robot.place(4, 0, EAST);
        robot.move();
        robot.move();
        assertEquals("4,0,EAST", robot.report());
    }

    @Test
    public void testMoveOffWestEdge() {
        robot.place(0, 0, WEST);
        robot.move();
        robot.move();
        assertEquals("0,0,WEST", robot.report());
    }

    @Test
    public void testPlaceOffNorthEdge() {
        robot.place(0, 5, NORTH);
        assertEquals("", robot.report());
    }

    @Test
    public void testPlaceOffSouthEdge() {
        robot.place(0, -1, SOUTH);
        assertEquals("", robot.report());
    }

    @Test
    public void testPlaceOffEastEdge() {
        robot.place(5, 0, EAST);
        assertEquals("", robot.report());
    }

    @Test
    public void testPlaceOffWestEdge() {
        robot.place(-1, 0, WEST);
        assertEquals("", robot.report());
    }
}
