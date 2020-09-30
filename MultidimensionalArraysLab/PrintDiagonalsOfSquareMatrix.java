package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[n][n];

        for (int row = 0; row < matrix.length ; row++) {
            int[] lineNumbers = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = lineNumbers;
        }
        for (int i = 0; i < matrix.length ; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        for (int i = 0; i <matrix.length ; i++) {
            int j = matrix.length - 1 - i;
            System.out.print(matrix[j][i] + " ");

        }
    }
}
