import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.Point;

public class Helper {

    // reading the input file and storing it in a list of String
    public static List<String> readFileToListLong(String filePath) throws IOException {
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

}
