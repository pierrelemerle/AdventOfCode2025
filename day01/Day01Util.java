import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day01Util {

    public static String[] readInputFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            return br.lines().toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    public static int calculatePasswordPart1(String[] rotations) {
        int currentPosition = 50;
        int zeroCount = 0;

        for (String rotation : rotations) {
            String direction = rotation.substring(0, 1);
            int distance = Integer.parseInt(rotation.substring(1));

            if (direction.equals("L")) {
                currentPosition = (currentPosition - distance + 100) % 100;
            } else if (direction.equals("R")) {
                currentPosition = (currentPosition + distance) % 100;
            }

            if (currentPosition == 0) {
                zeroCount++;
            }
        }

        return zeroCount;
    }


    public static int calculatePasswordPart2(String[] rotations) {
        int currentPosition = 50;
        int zeroCount = 0;

        for (String rotation : rotations) {
            String direction = rotation.substring(0, 1);
            int distance = Integer.parseInt(rotation.substring(1));
            if (distance >= 100){
                zeroCount+= distance /100;
                distance = distance %100;
            }
            if (direction.equals("L")) {
                if ((currentPosition!=0)&&(distance >= currentPosition)){
                    zeroCount++;
                }
                currentPosition = (currentPosition - distance + 100) % 100;
            } else if (direction.equals("R")) {
                if (distance+currentPosition>=100){
                    zeroCount++;
                }
                currentPosition = (currentPosition + distance) % 100;
            }
        }

        return zeroCount;
    }

}


