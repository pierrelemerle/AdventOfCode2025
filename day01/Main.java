public class Main {
    public static void main(String[] args) {
        String filename = "inputday1.txt"; // Change to your input file path
        String[] rotations = Day01Util.readInputFile(filename);

        // Calculate passwords for both parts
        int passwordPart1 = Day01Util.calculatePasswordPart1(rotations);
        int passwordPart2 = Day01Util.calculatePasswordPart2(rotations);
        // Output the results
        System.out.println("The password for Part 1 is: " + passwordPart1);
        System.out.println("The password for Part 2 is: " + passwordPart2);
    }
}