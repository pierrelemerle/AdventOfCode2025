import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {

            String filePath = "day08/resources/input.txt";
            // reading the file
            List<Point3D> points = Helper.readFileToListPoints(filePath);

            // Find the closest pairs and then build the connections
            List<Pair> closestPairs = Day08Util.findClosestPairs(points);
            System.out.println("Last Closest Pairs Found: " + closestPairs.getLast().toString());
            List<List<Point3D>> connections = Day08Util.connectPoints(points, closestPairs, 1000);
            
            int answerPart1 = Day08Util.countLargestConnections(connections, 3);
            int closingconnection = Day08Util.connectPoints(points, closestPairs);
            int answerPart2 = Day08Util.calculateAnswer2(closestPairs.get(closingconnection-1));

            // Output the results
            System.out.println("The answer for Part 1 is: " + answerPart1);     
            System.out.println("The answer for Part 2 is: " + answerPart2);
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}