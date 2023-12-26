package placement_training;
import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.next();
        String compressedString = compressString(inputString);
        System.out.println("Compressed String: " + compressedString);
        scanner.close();
    }
    private static String compressString(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        StringBuilder compressed = new StringBuilder();
        char currentChar = input.charAt(0);
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == currentChar) {
                count++;
            } else {
                compressed.append(currentChar);
                if (count > 1) {
                    compressed.append(count);
                }
                currentChar = input.charAt(i);
                count = 1;
            }
        }
        compressed.append(currentChar);
        if (count > 1) {
            compressed.append(count);
        }
        return compressed.toString();
    }
}
