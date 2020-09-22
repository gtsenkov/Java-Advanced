package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistoryLab01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String input = scan.nextLine();
        String current = "";


        while (!"Home".equals(input)) {
            if ("back".equals(input)) {
                if (stack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            } else {
                current = input;
                stack.push(input);
                System.out.println(stack.peek());
            }

            input = scan.nextLine();
        }
    }
}
