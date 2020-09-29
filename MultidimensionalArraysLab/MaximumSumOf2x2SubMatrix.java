package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] matrixData = scan.nextLine().split(", ");
        int rows = Integer.parseInt(matrixData[0]);
        int columns = Integer.parseInt(matrixData[1]);

        int[][] mainMatrix = readMatrix(scan, rows, columns);

        int maxSumOfSubMatrix = searchMaxSum(mainMatrix);

        System.out.println(maxSumOfSubMatrix);
    }

    private static int searchMaxSum(int[][] mainMatrix) {
        int maxSum = Integer.MIN_VALUE;
        int[][] maxMatrix = new int[2][2];
        for (int i = 0; i < mainMatrix.length - 1; i++) {
            for (int j = 0; j < mainMatrix[i].length - 1; j++) {
                int currentSum = mainMatrix[i][j] + mainMatrix[i + 1][j]
                        + mainMatrix[i][j + 1] + mainMatrix[i + 1][j + 1];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxMatrix[0][0] = mainMatrix[i][j];
                    maxMatrix[0][1] = mainMatrix[i][j + 1];
                    maxMatrix[1][1] = mainMatrix[i + 1][j + 1];
                    maxMatrix[1][0] = mainMatrix[i + 1][j];
                    }
                }
            }
        for (int[] matrix : maxMatrix) {
            for (int i : matrix) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        return maxSum;
    }

    private static int[][] readMatrix(Scanner scan, int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
