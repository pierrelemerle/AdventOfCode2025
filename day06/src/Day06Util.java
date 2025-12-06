
import java.util.ArrayList;
import java.util.List;

public class Day06Util {

    public static Long calculate(List<List<String>> listListString) {
        Long result = 0L;
        for (int i = 0; i < listListString.get(0).size(); i++) {
            List<Integer> listInt = new ArrayList<>();
            for (List<String> listString : listListString) {
                if (listString.get(i).equals("+")) {
                    result += additionate(listInt);
                }  
                else if (listString.get(i).equals("*")) {
                    result += multiply(listInt);
                } 
                else {  
                    listInt.add(Integer.parseInt(listString.get(i)));
                }
            }
        }
        return result;
    }


    //for part 2
    public static Long calculateAndTranspose(List<List<String>> listListString) {
        Long result = 0L;
        for (int i = 0; i < listListString.get(0).size(); i++) {
            List<String> listNb = new ArrayList<>();
            for (List<String> listString : listListString) {
                if (listString.get(i).trim().equals("+")) {
                    result += additionate(transpose(listNb));
                }  
                else if (listString.get(i).trim().equals("*")) {
                    result += multiply(transpose(listNb));
                } 
                else {  
                    listNb.add(listString.get(i));
                }
            }
        }
        return result;
    }


    private static Long additionate(List<Integer> listInt) {
        Long result = 0L;
        for (Integer integer : listInt) {
            result += integer;
        }
        return result;
    }

    private static Long multiply(List<Integer> listInt) {
        Long result = 1L;
        for (Integer integer : listInt) {
            result *= integer;
        }
        return result;
    }

    private static List<Integer> transpose(List<String> listInt) {
        List<Integer> result = new ArrayList<>();
        Integer max =0;
        for (String string : listInt) {
            Integer integer = Integer.parseInt(string.trim());
            if (integer > max) {
                max = integer;
            }
        }
        int digits = String.valueOf(max).length();
        for (int i = 0; i < digits; i++) {
            String string = "";
            for (int j=0; j<listInt.size(); j++) {
                string +=  listInt.get(j).charAt(i); 
            }
            result.add(Integer.parseInt(string.trim()));
        }
        return result;
    }

}


