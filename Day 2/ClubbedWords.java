package placement_training;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class ClubbedWords {
    public static List<String> findAllClubbedWords(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            wordSet.remove(word); 
            if (isClubbedWord(word, wordSet)) {
                result.add(word);
            }
            wordSet.add(word);
        }
        return result;
    }
    private static boolean isClubbedWord(String word, Set<String> wordSet) {
        if (word.isEmpty()) {
            return false;
        }
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                String prefix = word.substring(j, i);
                if (dp[j] && wordSet.contains(prefix)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
    public static void main(String[] args) {
        String[] words = {"mat", "mate", "matbellmates", "bell", "bellmatesbell", "butterribbon", "butter", "ribbon"};
        List<String> clubbedWords = findAllClubbedWords(words);
        System.out.println(clubbedWords);
    }
}
