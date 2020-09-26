package StacksaAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] operations = scan.nextLine().split(" ");
        String[] stackInput = scan.nextLine().split("\\s+");

        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();

        for (int i = 0; i < Integer.parseInt(operations[0]); i++) {
            stackNumbers.push(Integer.parseInt(stackInput[i]));
        }
        if (Integer.parseInt(operations[0]) > Integer.parseInt(operations[1])) {
            for (int i = 0; i < Integer.parseInt(operations[1]); i++) {
                stackNumbers.pop();
            }
        } else if ((Integer.parseInt(operations[0]) == Integer.parseInt(operations[1]))) {
            System.out.println(0);
            return;
        }
        int minNum = Integer.MAX_VALUE;
        boolean xPresentInStack = false;
        while (!stackNumbers.isEmpty()) {
            if (stackNumbers.peek() == Integer.parseInt(operations[2])) {
                System.out.println("true");
                xPresentInStack = true;
                break;
            }
            if (stackNumbers.peek() < minNum) {
                minNum = stackNumbers.peek();
                //System.out.println(Collections.min(stackNumbers));
               // System.out.println(stackNumbers.stream().mapToInt(e -> e).min().getAsInt());
            }
            stackNumbers.pop();
        }
        if (!xPresentInStack) {
            System.out.println(minNum);
        }


    }
}
