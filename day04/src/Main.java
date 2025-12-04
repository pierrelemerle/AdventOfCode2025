import java.io.IOException;

public class Main {
    public static void main(String[] args) {
    try {
        String filename = "day04/resources/inputday4.txt"; 
        char[][] tabTabChar = Helper.readFileToTabTabChar(filename);

        int answerPart1 = Day04Util.numberRolls(tabTabChar);
        int nbRemovedRolls = Day04Util.removeRolls(tabTabChar);
        int answerPart2 = nbRemovedRolls;

        while (nbRemovedRolls > 0) {
            nbRemovedRolls = Day04Util.removeRolls(tabTabChar);
            answerPart2 += nbRemovedRolls;
        }

        // Output the results
        System.out.println("The answer for Part 1 is: " + answerPart1);
        System.out.println("The answer for Part 2 is: " + answerPart2);
    } catch (IOException e) {
        System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
    }
}
}