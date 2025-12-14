public class Day12Util {
    
    public static Boolean[][] rotateRight(Boolean[][] pattern) {
        int size = pattern.length;
        Boolean[][] rotated = new Boolean[size][size];
        rotated[1][1] = pattern[1][1]; // center remains the same
        rotated[0][0] = pattern[2][0];
        rotated[0][1] = pattern[1][0];
        rotated[0][2] = pattern[0][0];
        rotated[1][0] = pattern[2][1];
        rotated[1][2] = pattern[0][1];
        rotated[2][0] = pattern[2][2];
        rotated[2][1] = pattern[1][2];
        rotated[2][2] = pattern[0][2];
        return rotated;
    }

    public static Boolean[][] rotateTwice(Boolean[][] pattern) {
        return rotateRight(rotateRight(pattern));
    }

    public static Boolean[][] rotateLeft(Boolean[][] pattern) {
        return rotateRight(rotateRight(rotateRight(pattern)));
    }

    public void printPattern(Boolean[][] pattern) {
        for (Boolean[] row : pattern) {
            for (Boolean cell : row) {
                System.out.print(cell ? "#" : ".");
            }
            System.out.println();
        }
    }

}

