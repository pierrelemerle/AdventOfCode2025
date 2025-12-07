import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {

            String filePath = "day07/resources/input.txt";
            // reading the file
            char[][] map = Helper.readFileToTabTabChar(filePath);

            String[][] stringMap = Day07Util.convert(map);
            int answerPart1 = Day07Util.resolve(map);
            stringMap = Day07Util.resolveAndCount(stringMap);
            long answerPart2 = Day07Util.calculateNbPositions(stringMap);

            // Output the results
            System.out.println("The answer for Part 1 is: " + answerPart1);     
            System.out.println("The answer for Part 2 is: " + answerPart2);
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}