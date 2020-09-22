package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputDecimal = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> binaryStack = new ArrayDeque<>();

        if (inputDecimal == 0) {
            System.out.println(0);
        } else {
            while (inputDecimal != 0) {
                binaryStack.push(inputDecimal % 2);
                inputDecimal = inputDecimal / 2;
            }
            while (!binaryStack.isEmpty()) {
                System.out.print(binaryStack.pop());
            }
        }
    }
}
