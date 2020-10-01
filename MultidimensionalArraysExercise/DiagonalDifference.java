package MultidimensionalArrays;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[size][size];

        int sumD1 = 0;
        int sumD2 = 0;


        for (int row = 0; row < size ; row++) {
            for (int col = 0; col < size ; col++) {
                matrix[row][col] = scan.nextInt();
                if (row == col) {
                    sumD1 += matrix[row][col];

                }
                if (col == size - 1 - row ) {
                    sumD2 += matrix[row][col];
                }
            }
        }
        System.out.println(Math.abs(sumD1 - sumD2));
    }
}
