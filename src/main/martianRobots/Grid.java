package martianRobots;

import java.util.HashSet;
import java.util.Set;

public class Grid {
    private final int maxX;
    private final int maxY;
    private final Set<String> scentMarks;

    public Grid(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.scentMarks = new HashSet<>();
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public boolean isOffGrid(int x, int y) {
        return x < 0 || y < 0 || x > maxX || y > maxY;
    }

    public boolean hasScentMark(int x, int y) {
        String scentMark = x + " " + y;
        return scentMarks.contains(scentMark);
    }

    public void addScentMark(int x, int y) {
        String scentMark = x + " " + y;
        scentMarks.add(scentMark);
    }
}
