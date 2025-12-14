import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {   

            String filePath = "day11/resources/input.txt";
            // reading the file
            Map<String, List<String>> map = Helper.readFileToMap(filePath);

            List<Integer> allPaths = Day11Util.findAllPath(map);
            int answerPart1 = allPaths.size();
            System.out.println("The answer for Part 1 is: " + answerPart1);     

            int answerPart2  = Day11Util.nbPathPart2(map).size();
            System.out.println("The answer for Part 2 is: " + answerPart2);   
  
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}