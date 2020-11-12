package JavaAdvancedRetakeExamAugust2020;

import java.util.*;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] integerLilies = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stackLilies = new ArrayDeque<>();
        for (Integer integerLily : integerLilies) {
            stackLilies.push(integerLily);
        }

        ArrayDeque<Integer> queueRoses = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        int wreathsCounter = 0;

        int flowersLeft = 0;

        while (!stackLilies.isEmpty() && !queueRoses.isEmpty()) {
            if (stackLilies.peek() + queueRoses.peek() == 15) {
                wreathsCounter++;
                stackLilies.pop();
                queueRoses.poll();
            } else {
                while (stackLilies.peek() + queueRoses.peek() >= 15) {
                    int liliesUpdate = stackLilies.pop() - 2;
                    stackLilies.push(liliesUpdate);
                    if (stackLilies.peek() + queueRoses.peek() == 15) {
                        wreathsCounter++;
                        stackLilies.pop();
                        queueRoses.poll();
                        break;
                    }
                }
                if (stackLilies.peek() + queueRoses.peek() < 15) {
                    flowersLeft += stackLilies.pop() + queueRoses.poll();
                }
            }
        }

        if (flowersLeft > 0) {
            wreathsCounter += (flowersLeft / 15);
        }

        int ringsNeed = 5 - wreathsCounter;

        if (wreathsCounter >= 5) {
            System.out.println(String.format("You made it, you are going to the competition with" +
                    " %d wreaths!", wreathsCounter));
        } else {
            System.out.println(String.format("You didn't make it, you need " +
                    "%d wreaths more!", ringsNeed));
        }



    }
}
