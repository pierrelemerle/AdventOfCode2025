import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Helper {

    public static List<List<String>> readFileToListListString(String filename) throws IOException {
        List<List<String>> numberGroups = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filename)))) {
            String line;
            List<String> currentGroup = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                for (String part : parts) {
                    currentGroup.add(part);
                }
                numberGroups.add(new ArrayList<>(currentGroup));
                currentGroup.clear(); 
            }
        }

        return numberGroups;
    }

    //specific function for day06 2025 part2
    public static List<List<String>> extractSubstrings(String filePath, List<Integer> coordinates) {
        List<List<String>> substrings = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                List<String> lineSubstrings = new ArrayList<>();

                // Extract substrings based on the coordinates
                for (int i = 0; i < coordinates.size(); i++) {
                    int start = coordinates.get(i);
                    int end = (i + 1 < coordinates.size()) ? coordinates.get(i + 1) : currentLine.length();
                    String substring = currentLine.substring(start, Math.min(end, currentLine.length()));
                    lineSubstrings.add(substring); 
                }
                substrings.add(lineSubstrings);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return substrings;
    }

    //specific function for day06 2025 part2
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

    // reading the input file and storing it in a list of String
    public static List<String> readFileToListString(String filePath) throws IOException {
        List<String> resultList = new ArrayList<>();
        try {
            // Read all lines as a single string
            String content = Files.readString(Paths.get(filePath));

            String[] stringIds = content.trim().split(","); 
            for (String id : stringIds) {   
                resultList.add(id);
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return resultList;
    }


    // reading the input file and storing it in a list of String
    public static List<List<Integer>> readFileToListListInt(String filePath) throws IOException {
        List<List<Integer>> resultList = new ArrayList<>();
        try {
            // Read all lines as a single string
            String content = Files.readString(Paths.get(filePath));

            String[] stringIds = content.trim().split("\\s+"); 
            
            for (String id : stringIds) {  
                List<Integer> list = new ArrayList<>(); 
                for (int i=0;i<id.length();i++){
                    list.add(Integer.parseInt(String.valueOf(id.charAt(i))));
                }
                resultList.add(list);
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return resultList;
    }


    // reading the input file and storing it in 2 dimension tab of characters
    public static char[][] readFileToTabTabChar(String filePath) throws IOException {
        List<String> resultList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                resultList.add(line);
            }
        }
        // Create a char[][] with size equal to the list size
        char[][] result = new char[resultList.size()][];

        // Populate the char[][] using each string in the list
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i).toCharArray();
        }
        return result;
    }

}
