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
    
    public static List<Machine> readFileToListMachine(String filePath) throws IOException {
        
        List<Machine> machines = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                boolean[] lights ;
                List<List<Integer>> buttons = new ArrayList<>();
                List<Integer> voltages = new ArrayList<>(); 
                
                // Parse square brackets
                String squareBrackets = line.substring(line.indexOf('[') + 1, line.indexOf(']'));
                lights = new boolean[squareBrackets.length()];
                for (int i=0;i<squareBrackets.length();i++){
                    if (squareBrackets.charAt(i) == '.')
                        lights[i] = false;
                    else
                        lights[i] = true;
                }

                // Parse round brackets
                int startIndex = line.indexOf('(');
                while (startIndex != -1) {
                    int endIndex = line.indexOf(')', startIndex);
                    List<Integer> intList = new ArrayList<>();
                    if (endIndex != -1) {
                        String roundBrackets = line.substring(startIndex + 1, endIndex);
                        String[] numbers = roundBrackets.split(",");
                        for (String num : numbers) {
                            intList.add(Integer.parseInt(num.trim()));
                        }
                        buttons.add(intList);
                        startIndex = line.indexOf('(', endIndex);
                    } else {
                        break;
                    }
                }

                // Parse curly brackets
                int curlyStartIndex = line.indexOf('{');
                if (curlyStartIndex != -1) {
                    int curlyEndIndex = line.indexOf('}', curlyStartIndex);
                    String curlyBrackets = line.substring(curlyStartIndex + 1, curlyEndIndex);
                    String[] curlyNumbers = curlyBrackets.split(",");
                    for (String num : curlyNumbers) {
                        voltages.add(Integer.parseInt(num.trim()));
                    }
                }
                Machine machine = new Machine(lights, buttons, voltages);
                machines.add(machine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return machines;
    }

}
