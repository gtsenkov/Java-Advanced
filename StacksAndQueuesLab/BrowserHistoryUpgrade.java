package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> stackBack = new ArrayDeque<>();
        ArrayDeque<String> stackForward = new ArrayDeque<>();
        String input = scan.nextLine();
        String current = "";


        while (!"Home".equals(input)) {
            if ("back".equals(input)) {
                if (stackBack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    stackForward.push(stackBack.pop());
                    System.out.println(stackBack.peek());
                }
            } else if ("forward".equals(input)) {
                if (stackForward.size() == 0) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(stackForward.peek());
                    stackBack.push(stackForward.pop());
                }
            } else {
                current = input;
                stackBack.push(input);
                System.out.println(stackBack.peek());
                stackForward.clear();
            }

            input = scan.nextLine();
        }
    }
}
