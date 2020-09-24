package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] children = scan.nextLine().split(" ");
        int n = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> participantQueue = new ArrayDeque<>();
        for (String child : children) {
            participantQueue.offer(child);
        }
        while ((participantQueue.size() > 1)) {
            for (int i = 1; i < n; i++) {
                participantQueue.offer(participantQueue.poll());
            }
            System.out.println("Removed " + participantQueue.poll());
        }

        System.out.println("Last is " + participantQueue.poll());

    }
}
