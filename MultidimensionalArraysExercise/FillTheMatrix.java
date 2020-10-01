package MultidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[size][size];
        int n = 1;

        if (pattern.equals("A")) {
            for (int col = 0; col < size; col++) {
                for (int row = 0; row < size ; row++) {
                    matrix[row][col] = n;
                    n++;
                }
            }
        }
        if (pattern.equals("B")) {
            for (int col = 0; col < size; col++) {
                if (col % 2 != 0) {
                    for (int row = size - 1; row >= 0; row--) {
                        matrix[row][col] = n;
                        n++;
                    }
                } else {
                    for (int row = 0; row < size; row++) {
                        matrix[row][col] = n;
                        n++;
                    }
                }
            }
        }
        for (int[] ints : matrix) {
            for (int num : ints) {
                System.out.print(num + " ");
            }
            System.out.println();

        }
    }
}
