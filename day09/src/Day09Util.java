import java.util.ArrayList;
import java.util.List;

public class Day09Util {

    //part 1
    public static List<Rectangle> findRectangles(List<Point2D> points) {
        List<Rectangle> rectangles = new ArrayList<>();
        // Loop through all combinations of points and list their distances
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                Point2D pointA = points.get(i);
                Point2D pointB = points.get(j);
                long size = calculateSize(pointA, pointB);        
                rectangles.add(new Rectangle(pointA, pointB, size));
            }
        }
        // Sort the pairs based on distance
        rectangles.sort((rect1, rect2) -> Double.compare(rect1.getSize(), rect2.getSize()));
        // Return only the first 'numberOfPairs' closest pairs
        return rectangles;
    }
    
    private static long calculateSize(Point2D pointA, Point2D pointB) {
        long deltaX = 0;
        if (pointA.getX() > pointB.getX()) {
            deltaX =  pointA.getX() - pointB.getX()+1;
        } else {
            deltaX = pointB.getX() - pointA.getX()+1;
        }
        long deltaY = 0;
        if (pointA.getY() > pointB.getY()) {
            deltaY = pointA.getY() - pointB.getY()+1;
        } else {
            deltaY = pointB.getY() - pointA.getY()+1;
        }
        return deltaX * deltaY;
    }

    public static void printGrid(char[][] grid) {
        for (char[] row : grid) {
            for (char tile : row) {
                System.out.print(tile);
            }
            System.out.println();
        }
    }

}

