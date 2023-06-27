package martianRobots;

public class Robot {

    private int xCoord;
    private int yCoord;
    private char orientation;

    public Robot(int xCoord, int yCoord, char orientation) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.orientation = orientation;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }
}
