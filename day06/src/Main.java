import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            String filename = "day06/resources/input.txt"; 

            List<List<String>> ListListString = Helper.readFileToListListString(filename);
            Long answerPart1 = Day06Util.calculate(ListListString);
        
            List<Integer> coordinates = Helper.getNonSpaceCoordinates(filename);
            List<List<String>> substrings = Helper.extractSubstrings(filename, coordinates);
            Long answerPart2 = Day06Util.calculateAndTranspose(substrings);

            // Output the results
            System.out.println("The answer for Part 1 is: " + answerPart1);     
            System.out.println("The answer for Part 2 is: " + answerPart2);
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}