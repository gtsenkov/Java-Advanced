package StacksaAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] commands = scan.nextLine().split(" ");
        String[] inputQueue = scan.nextLine().split(" ");

        ArrayDeque<Integer> numQueue = new ArrayDeque<>();

        for (int i = 0; i < Integer.parseInt(commands[0]); i++) {
            numQueue.offer(Integer.parseInt(inputQueue[i]));
        }
        for (int i = 0; i < Integer.parseInt(commands[1]) ; i++) {
            numQueue.poll();
        }
        if (numQueue.isEmpty()) {
            System.out.println(0);
            return;
        }
        int min = Collections.min(numQueue);
        for (Integer num : numQueue) {
            if (numQueue.peek() == Integer.parseInt(commands[2])) {
                System.out.println("true");
                return;
            }
            numQueue.poll();
        }
        System.out.println(min);
    }
}
