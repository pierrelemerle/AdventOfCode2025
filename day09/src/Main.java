import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {   

            String filePath = "day09/resources/input.txt";
            // reading the file
            List<Point2D> points = Helper.readFileToListPoints(filePath);
            
            // Find the closest pairs and then build the connections
            List<Rectangle> rectangles = Day09Util.findRectangles(points);
            long answerPart1 = rectangles.get(rectangles.size() - 1).getSize();

            System.out.println("The answer for Part 1 is: " + answerPart1);     

            // For part 2
            boolean[][] grid = Day09Util.buildGrid(points, 100000, 100000);
            rectangles = Day09Util.findRectanglesPart2(points, grid);
            long answerPart2 = rectangles.get(rectangles.size() - 1).getSize();

            System.out.println("The answer for Part 2 is: " + answerPart2);
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}