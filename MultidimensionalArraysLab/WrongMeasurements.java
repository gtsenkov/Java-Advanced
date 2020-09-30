package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[] wrongData = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int wrongValue = matrix[wrongData[0]][wrongData[1]];

        ArrayList<int[]> wrongIndexes = new ArrayList<>();
        ArrayList<Integer> correctValues = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    wrongIndexes.add(new int[]{row, col});
                    correctValues.add(getCorrectValues(matrix, row, col, wrongValue));
                }
            }

        }
        for (int i = 0; i < wrongIndexes.size() ; i++) {
            int[] rowAndCol = wrongIndexes.get(i);
            matrix[rowAndCol[0]][rowAndCol[1]] = correctValues.get(i);
        }
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static Integer getCorrectValues(int[][] matrix, int row, int col, int wrongValue) {
        int sum = 0;
        if (isInBounds(matrix, row - 1, col) && wrongValue != matrix[row - 1][col]) {
            sum += matrix[row - 1][col];
        }
        if (isInBounds(matrix, row + 1, col) && wrongValue != matrix[row + 1][col]) {
            sum += matrix[row + 1][col];
        }
        if (isInBounds(matrix, row, col - 1) && wrongValue != matrix[row][col - 1]) {
            sum += matrix[row][col - 1];
        }
        if (isInBounds(matrix, row, col + 1) && wrongValue != matrix[row][col + 1]) {
            sum += matrix[row][col + 1];
        }

        return sum;
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
