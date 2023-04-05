import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ToyRobotTest {

    private static final String NORTH = "NORTH";
    private static final String SOUTH = "SOUTH";
    private static final String EAST = "EAST";
    private static final String WEST = "WEST";

    ToyRobot robot = new ToyRobot();

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
