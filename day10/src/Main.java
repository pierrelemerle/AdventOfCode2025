
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {   

            String filePath = "day10/resources/input.txt";
            // reading the file
            List<Machine> machines = Helper.readFileToListMachine(filePath);
            for (Machine machine : machines) {
                System.out.println(machine);
            }
            int answerPart1 = 0;
            for (Machine machine : machines) {
                answerPart1 += Day10Util.resolveMachine(machine);
            }
            System.out.println("The answer for Part 1 is: " + answerPart1);     

            // For part 2
            //long answerPart2 = rectangles.get(rectangles.size() - 1).getSize();
            // Output the results
            //System.out.println("The answer for Part 2 is: " + answerPart2);
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}