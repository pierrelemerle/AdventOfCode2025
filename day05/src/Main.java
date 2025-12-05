import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            String filename = "day05/resources/inputday5.txt";
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
            String line;

            List<long[]> validIntervals = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    break; 
                }
                String[] parts = line.split("-");
                Long x = Long.parseLong(parts[0]);
                Long y = Long.parseLong(parts[1]);
                validIntervals.add(new long[]{x, y});
            }

            int nbValidProduct = 0;
            while ((line = reader.readLine()) != null) {
                Long id = Long.parseLong(line);
                if (Day05Util.isValid(id, validIntervals)) {
                    nbValidProduct++;
                }
            }
            reader.close();
            List<long[]> mergedIntervals = Day05Util.mergeIntervals(validIntervals);
            long totalValidNumbers = Day05Util.calculateTotalValidNumbers(mergedIntervals);

            // Output the results
            System.out.println("The answer for Part 1 is: " + nbValidProduct);
            System.out.println("The answer for Part 2 is: " + totalValidNumbers);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format: " + e.getMessage());
        }
    }

}