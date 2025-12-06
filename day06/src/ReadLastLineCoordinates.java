import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadLastLineCoordinates {

    public static void main(String[] args) {
        String filePath = "../resources/input.txt"; // Path to your input file
        List<Integer> coordinates = getNonSpaceCoordinates(filePath);
        
        // Print the coordinates
        System.out.println("Coordinates of non-space characters: " + coordinates);
    }

    public static List<Integer> getNonSpaceCoordinates(String filePath) {
        List<Integer> coordinates = new ArrayList<>();
        String lastLine = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                lastLine = currentLine; // Store the last line read
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Iterate over the last line to find non-space characters
        for (int i = 0; i < lastLine.length(); i++) {
            if (lastLine.charAt(i) != ' ') {
                coordinates.add(i); // Store the index if it's not a space
            }
        }

        return coordinates;
    }
}