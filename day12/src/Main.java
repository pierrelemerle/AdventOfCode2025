import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {   

            String filePath = "day12/resources/inputexemple.txt";
            Scanner scanner = new Scanner(new File(filePath));

            Map<Integer, Boolean[][]> allPatterns = new HashMap<>();
            allPatterns.put(0, new Boolean[][] {
                {true, true, true},
                {true, false, true},
                {true, false, true}
            });
            allPatterns.put(1, new Boolean[][] {
                {true, false, false},
                {true, true, false},
                {false, true, true}
            });
            allPatterns.put(2, new Boolean[][] {
                {true, true, false},
                {true, true, true},
                {true, false, true}
            }); 
            allPatterns.put(3, new Boolean[][] {
                {false, false, true},
                {false, true, true},
                {true, true, true}
            });
            allPatterns.put(4, new Boolean[][] {
                {true, true, false},
                {true, true, false},
                {true, true, true}
            });
            allPatterns.put(5, new Boolean[][] {
                {true, true, true},
                {false, true, false},
                {true, true, true}
            }); 

            List<Region> regions = new ArrayList<>();

            // Parse the part 1 of the file : rules
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty())
                    break; // Separator between rules and updates
                String[] parts = line.split(":");
                String[] parts2 = parts[1].trim().split(" ");
                int width = Integer.parseInt(parts[0].trim().split("x")[0]);
                int height = Integer.parseInt(parts[0].trim().split("x")[1]);
                int[] presents = new int [6];
                for (int i=0; i<6; i++) {
                    presents[i] = Integer.parseInt(parts2[i]);
                }
                Region region = new Region(width, height, presents);
                regions.add(region);
            }
            scanner.close();

            for (Region region : regions) {
                System.out.println(region);
            }   

            //int answerPart1 = allPaths.size();
            //System.out.println("The answer for Part 1 is: " + answerPart1);     

            //int answerPart2  = Day11Util.nbPathPart2(map).size();
            //System.out.println("The answer for Part 2 is: " + answerPart2);   
  
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}