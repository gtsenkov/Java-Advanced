package StacksaAndQueuesExercises;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static long[] memoryFib;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        memoryFib = new long[n + 1]; //големина на масива

        System.out.println(fibonacci(n));
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        if (memoryFib[n] != 0) {
            return memoryFib[n];
        }
        return memoryFib[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}

