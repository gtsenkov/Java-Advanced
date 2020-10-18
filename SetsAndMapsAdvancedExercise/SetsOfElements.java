package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();
        String[] input = scan.nextLine().split(" ");
        int firstSetLength = Integer.parseInt(input[0]);
        int secondSetLength = Integer.parseInt(input[1]);
        for (int i = 0; i < firstSetLength; i++) {
            firstSet.add(scan.nextLine());
        }
        for (int i = 0; i < secondSetLength; i++) {
            secondSet.add(scan.nextLine());
        }
       Set<String> intersection = new LinkedHashSet<>(firstSet);
        intersection.retainAll(secondSet);

        for (String string : intersection) {
            System.out.print(string + " ");

        }
    }
}
