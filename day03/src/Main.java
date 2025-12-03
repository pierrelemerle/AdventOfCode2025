import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    try {
        String filename = "day03/resources/inputday3.txt"; 
        List<List<Integer>> ids = Helper.readFileToListListInt(filename);

        int answerPart1 = 0;
        long answerPart2 = 0L;

        for (List<Integer> id : ids) {
            answerPart1+=Day03Util.biggestJoltage(id);
        }

        for (List<Integer> id : ids) {
            answerPart2+=Day03Util.getLargestJoltage(id);
        }

        // Output the results
        System.out.println("The answer for Part 1 is: " + answerPart1);
        System.out.println("The answer for Part 2 is: " + answerPart2);
    } catch (IOException e) {
        System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
    }
}
}