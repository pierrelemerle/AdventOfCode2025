import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) {
    try {
        String filename = "day02/resources/inputday2.txt"; 
        List<String> ids = Helper.readFileToListLong(filename);

        Long totalWrongIdsPart1 = 0L;
        Long totalWrongIdsPart2 = 0L;

        for (String id : ids) {
                String[] splitId = id.trim().split("-");
                totalWrongIdsPart1+=Day02Util.iterateAllIdsPart1(Long.parseLong(splitId[0]), Long.parseLong(splitId[1]));
                totalWrongIdsPart2+=Day02Util.iterateAllIdsPart2(Long.parseLong(splitId[0]), Long.parseLong(splitId[1]));
            }

        // Output the results
        System.out.println("The answer for Part 1 is: " + totalWrongIdsPart1);
        System.out.println("The answer for Part 2 is: " + totalWrongIdsPart2);
    } catch (IOException e) {
        System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
    }
}
}