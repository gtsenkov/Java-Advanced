package StacksaAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWith_A_Stack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numbers = scan.nextLine().split(" ");
        ArrayDeque<String> reverseNumbers = new ArrayDeque<>();
        for (int i = 0; i < numbers.length ; i++) {
            reverseNumbers.push(numbers[i]);
        }

        for (String number : reverseNumbers) {
            System.out.print(number + " ");

        }

    }
}
