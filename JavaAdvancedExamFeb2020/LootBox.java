package JavaAdvancedExamFeb2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LootBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> queueFirstBox = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        int[] stackBoxArr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stackSecondBox = new ArrayDeque<>();
        for (Integer integerLily : stackBoxArr) {
            stackSecondBox.push(integerLily);
        }

        int sumToClaim = 0;

        while (!queueFirstBox.isEmpty() && !stackSecondBox.isEmpty()) {
            int firstElementFirstBox = queueFirstBox.peek();
            int lastElementSecondBox = stackSecondBox.pop();
            int currentSum = firstElementFirstBox + lastElementSecondBox;

            if (currentSum % 2 == 0) {
                sumToClaim += currentSum;
                queueFirstBox.poll();
            } else {
                queueFirstBox.offer(lastElementSecondBox);
            }
        }

        if (queueFirstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (sumToClaim >= 100) {
            System.out.println(String.format("Your loot was epic! Value: %d", sumToClaim));
        } else {
            System.out.println(String.format("Your loot was poor... Value: %d", sumToClaim));
        }
    }
}

//40-45 min