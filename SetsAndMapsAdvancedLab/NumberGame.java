package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashSet<Integer> firstPlayer = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> secondPlayer = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0) {
            int firstCard = firstPlayer.iterator().next();
            firstPlayer.remove(firstCard);
            int secondCard = secondPlayer.iterator().next();
            secondPlayer.remove(secondCard);

            if (firstCard > secondCard) {
                firstPlayer.addAll(Arrays.asList(firstCard, secondCard));
            } else if (secondCard > firstCard){
                secondPlayer.addAll(Arrays.asList(firstCard, secondCard));
            }
            if (secondPlayer.isEmpty() || firstPlayer.isEmpty()) {
                System.out.println("Draw!");
                break;
            }
        }
        if (!secondPlayer.isEmpty() || !firstPlayer.isEmpty()) {
            if (firstPlayer.size() < secondPlayer.size()) {
                System.out.println("Second player win!");
            } else if ((firstPlayer.size() > secondPlayer.size())) {
                System.out.println("First player win!");
            }
        }
    }
}
