package MultidimensionalArrays;

import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();

        int[][] mainMatrix = new int[rows][cols];
        int maxSum = Integer.MIN_VALUE;
        int[] maxIndex = {0, 0};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                mainMatrix[row][col] = scan.nextInt();
            }
        }

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int currentSum = (mainMatrix[row][col]) + (mainMatrix[row][col + 1]) + (mainMatrix[row][col + 2])
                        + (mainMatrix[row + 1][col]) + (mainMatrix[row + 1][col + 1]) + (mainMatrix[row + 1][col + 2])
                        + (mainMatrix[row + 2][col]) + (mainMatrix[row + 2][col + 1]) + (mainMatrix[row + 2][col + 2]);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxIndex[0] = row;
                    maxIndex[1] = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int row = maxIndex[0]; row < maxIndex[0] + 3; row++) {
            for (int col = maxIndex[1]; col < maxIndex[1] + 3; col++) {
                System.out.print(mainMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
