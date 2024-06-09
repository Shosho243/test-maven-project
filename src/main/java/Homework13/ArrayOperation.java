package Homework13;

import java.util.*;

public class ArrayOperation {
    public static void main(String[] args) {
        String[] wordsArray = {"apple", "banana", "apple", "orange", "banana",
                "grape", "kiwi", "apple", "orange", "apple"};
        List<String> unique = new ArrayList<>();
        Map<String, Integer> repeatCount = new HashMap<>();
        for (int i = 0; i < wordsArray.length; i++) {
            int count = 0;
            for (int j = 0; j < wordsArray.length; j++) {
                if (wordsArray[i].equals(wordsArray[j]) && i != j) {
                    count++;
                }
            }
            repeatCount.put(wordsArray[i], count + 1);
            if (!unique.contains(wordsArray[i]) && count == 0) {
                unique.add(wordsArray[i]);
            }
        }
        System.out.println("Список уникальных слов:");
        for (String word : unique) {
            System.out.print(word + " ");
        }
        System.out.println();
        System.out.println("\nКоличество вхождений каждого слова:");
        for (Map.Entry<String, Integer> entry : repeatCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

