package placement_training;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MostCommonWordFinder {
    public static void main(String[] args) {
        System.out.print("Enter directory name: ");
        String directoryPath = System.console().readLine();

        try {
            Map<String, Integer> wordFrequencyMap = findMostCommonWord(directoryPath);
            System.out.println("Most Common Words and Frequencies:");
            for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
                System.out.println("Word: " + entry.getKey() + ", Frequency: " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
        }
    }
    private static Map<String, Integer> findMostCommonWord(String directoryPath) throws IOException {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    countWords(file, wordFrequencyMap);
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid directory path: " + directoryPath);
        }
        return wordFrequencyMap;
    }
    private static void countWords(File file, Map<String, Integer> wordFrequencyMap) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String cleanedWord = word.toLowerCase().trim();
                    wordFrequencyMap.put(cleanedWord, wordFrequencyMap.getOrDefault(cleanedWord, 0) + 1);
                }
            }
        }
    }
}
