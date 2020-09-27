package StacksaAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int commands = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> stackNum = new ArrayDeque<>();
        for (int i = 0; i < commands; i++) {
            String[] operation = scan.nextLine().split(" ");
            switch (operation[0]) {
                case "1":
                    stackNum.push(Integer.parseInt(operation[1]));
                    break;
                case "2":
                    stackNum.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(stackNum));
                    break;
            }
        }
    }
}
