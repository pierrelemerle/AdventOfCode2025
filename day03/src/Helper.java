import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Helper {

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

}
