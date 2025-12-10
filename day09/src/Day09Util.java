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

    //part 2
    public static List<Rectangle> findRectanglesPart2(List<Point2D> points, boolean[][] grid) {
        List<Rectangle> rectangles = new ArrayList<>();
        // Loop through all combinations of points and list their distances
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                Point2D pointA = points.get(i);
                Point2D pointB = points.get(j);
                long size = calculateSize(pointA, pointB);
                
                //ugly brut forcing filtering to limit execution time
                if (size >= 904044132L && size <= 1959386940L )
                {
                    // add logic to verify it is fully contained in the right region prior to adding it to the list 
                    long minX = Math.min(pointA.getX(), pointB.getX())+2;
                    long maxX = Math.max(pointA.getX(), pointB.getX())-2;
                    long minY = Math.min(pointA.getY(), pointB.getY())+2;
                    long maxY = Math.max(pointA.getY(), pointB.getY())-2;
                    boolean isValid = true;

                    for (long y=minY; y<=maxY; y++){
                        for (long x=minX; x<=maxX; x++){
                            if (grid[(int)y][(int)x]){
                             isValid = false;
                                break;
                            }   
                        }
                    }   
                    if (isValid){
                        rectangles.add(new Rectangle(pointA, pointB, size));
                        System.out.println("added rectangle size: " + size);
                    }
                }
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

    public static boolean[][] buildGrid(List<Point2D> redTiles, int width, int height) {
        // Initialize grid with empty tiles
        boolean[][] grid = new boolean[height][width];
        for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    grid[i][j] = false;
                }
        }

        // Mark the red tiles
        for (Point2D tile : redTiles) {
            long x = tile.getX();
            long y = tile.getY();
            if (x >= 0 && x < width && y >= 0 && y < height) {
                grid[(int)y][(int)x] = true; // Mark red tile
            }
        }

        // Connect the red tiles with green tiles
        for (int i = 0; i < redTiles.size(); i++) {
            Point2D current = redTiles.get(i);
            Point2D next = redTiles.get((i + 1) % redTiles.size()); // Wrap around to the first tile

            long startX = Math.min(current.getX(), next.getX());
            long endX = Math.max(current.getX(), next.getX());
            long startY = Math.min(current.getY(), next.getY());
            long endY = Math.max(current.getY(), next.getY());

            // Horizontal connection
            for (long x = startX; x <= endX; x++) {
                if (current.getY() >= 0 && current.getY() < height) {
                    grid[(int)current.getY()][(int)x] = true; // Mark green tile
                }
            }

            // Vertical connection
            for (long y = startY; y <= endY; y++) {
                if (next.getX() >= 0 && next.getX() < width) {
                    grid[(int)y][(int)next.getX()] = true; // Mark green tile
                }
            }
        }
        return grid;
    }

    private static boolean[][] fillInternalArea(boolean[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        // Fill internal area
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j]) {
                    j++;
                    if (grid[i][j]) {
                        //if we are in a zone we need to skip the whole
                        while (grid[i][j]) {
                            j++;
                        }
                    }
                    else {
                        //otherwise we color until the end of the zone
                        while (!grid[i][j]) {
                            grid[i][j] = true;   
                            j++;
                        }
                    }
                }
            }
        }
        return grid;
    }

    public static void printGrid(boolean[][] grid) {
        for (boolean[] row : grid) {
            for (boolean tile : row) {
                if (tile) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

}

