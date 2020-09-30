package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] matrixData = scan.nextLine().split(" ");
        int rows = Integer.parseInt(matrixData[0]);
        int cols = Integer.parseInt(matrixData[1]);
        ArrayList<int[]> indexes = new ArrayList<>();

        String separator = " ";

        int [][] matrix = readMatrix(rows, cols, separator, scan);
        int numberToFind = Integer.parseInt(scan.nextLine());
        boolean isFound = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols ; col++) {
                if (matrix[row][col] == numberToFind) {
                    indexes.add(new int[]{row, col});
                    isFound = true;
                }
            }

        }
        if (!isFound) {
            System.out.println("not found");
        } else {
            for (int[] index : indexes) {
                System.out.println(index[0] + " " + index[1]);

            }
        }
    }

    private static int[][] readMatrix(int rows, int cols, String separator,Scanner scan) {
        int [][] matrix = new int[rows][cols];
        for (int row = 0; row < rows ; row++) {
            String[] numbersInRow = scan.nextLine().split(separator);
            for (int column = 0; column < cols ; column++) {
                matrix[row][column] = Integer.parseInt(numbersInRow[column]);
            }
        }
        return matrix;
    }
}
