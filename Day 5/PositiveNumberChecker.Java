package placement_training;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PositiveNumberChecker {
    public static void main(String[] args) {
        String filePath = "test.txt"; 
        try {
            checkForPositiveNumbers(filePath);
        } catch (PositiveNumberException e) {
            System.out.println("Content of " + filePath + ": " + e.getFileContent());
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    private static void checkForPositiveNumbers(String filePath) throws IOException, PositiveNumberException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder fileContent = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append(" ");
                String[] numbers = line.split("\\s+");
                for (String number : numbers) {
                    int num = Integer.parseInt(number);
                    if (num > 0) {
                        throw new PositiveNumberException(fileContent.toString(), "Positive number found: " + num);
                    }
                }
            }
        }
    }

    static class PositiveNumberException extends Exception {
        private final String fileContent;
        public PositiveNumberException(String fileContent, String message) {
            super(message);
            this.fileContent = fileContent;
        }
        public String getFileContent() {
            return fileContent;
        }
    }
}
