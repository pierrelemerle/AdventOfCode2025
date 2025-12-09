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
            
            long answerPart1 = rectangles.getLast().getSize();
            //int answerPart2 = Day09Util.calculateAnswer2(closestPairs.get(closingconnection-1));

            // Output the results
            System.out.println("The answer for Part 1 is: " + answerPart1);     
            //System.out.println("The answer for Part 2 is: " + answerPart2);
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}