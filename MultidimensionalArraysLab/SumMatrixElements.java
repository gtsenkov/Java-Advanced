package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] matrixData = scan.nextLine().split(", ");
        int rows = Integer.parseInt(matrixData[0]);
        int columns = Integer.parseInt(matrixData[1]);

        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows ; row++) {
            int[] numbers = Arrays.stream(scan.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = numbers;
        }
        int sum = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += num;
            }
        }
        System.out.println(rows);
        System.out.println(columns);
        System.out.println(sum);
    }
}
