package SetsAndMapsAdvancedExercise;

import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Character, Integer> inputAsLetters = new TreeMap<>();

        String input = scan.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char currentLetter = input.charAt(i);
            inputAsLetters.putIfAbsent(currentLetter, 0);
            inputAsLetters.put(currentLetter, inputAsLetters.get(currentLetter) + 1);
        }

        for (Map.Entry<Character, Integer> entry : inputAsLetters.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());

        }
    }
}
