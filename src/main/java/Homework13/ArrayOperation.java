package Homework13;

import java.util.*;

public class ArrayOperation {
    public static void main(String[] args) {
        String[] wordsArray = {"apple", "banana", "apple", "orange", "banana",
                "grape", "kiwi", "apple", "orange", "apple"};
        List<String> wordsList = Arrays.asList(wordsArray);
        Set<String> uniqueWords = new HashSet<>(wordsList);
        System.out.println("Уникальные слова");
        for (String word : uniqueWords) {
            System.out.println(word);
        }
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : wordsList) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("\nКоличевство повторений каждого слова : ");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

