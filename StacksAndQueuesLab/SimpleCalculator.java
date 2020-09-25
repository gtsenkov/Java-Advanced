package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        ArrayDeque<String> calculator = new ArrayDeque<>();
        int result = Integer.parseInt(input[0]);
        for (int i = 1; i < input.length; i += 2) {
            String operation = input[i];
            int argument = Integer.parseInt(input[i + 1]);
            switch (operation) {
                case "+":
                    result = result + argument;
                break;
                case "-":
                    result = result - argument;
                    break;
            }
        }
        System.out.println(result);
    }
}
