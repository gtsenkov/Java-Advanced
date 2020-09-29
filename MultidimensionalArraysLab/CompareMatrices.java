package MultidimensionalArraysLab;

import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String pattern = " ";
        int [][] matrixFirst = readMatrix(scan, pattern);
        int [][] matrixSecond = readMatrix(scan, pattern);

        String result = matricesComparison(matrixFirst, matrixSecond);
        System.out.println(result);
    }

    private static String matricesComparison(int[][] matrixFirst, int[][] matrixSecond) {
        if (matrixFirst.length != matrixSecond.length) {
            return "not equal";
        }
        for (int row = 0; row < matrixFirst.length ; row++) {
            if (matrixFirst[row].length != matrixSecond[row].length) {
                return "not equal";
            }
            for (int col = 0; col < matrixFirst[row].length ; col++) {
                if (matrixFirst[row][col] != matrixSecond[row][col]) {
                    return "not equal";
                }

            }

        }
        return "equal";
    }

    public static int[][] readMatrix(Scanner scan, String pattern) {
        String[] matrixData = scan.nextLine().split(pattern);
        int rows = Integer.parseInt(matrixData[0]);
        int cols = Integer.parseInt(matrixData[1]);
        int [][] matrix = new int[rows][cols];


        for (int row = 0; row < rows ; row++) {
            String[] matrixNumbers = scan.nextLine().split(pattern);
            for (int col = 0; col < cols ; col++) {
                matrix[row][col] = Integer.parseInt(matrixNumbers[col]);
            }
        } return matrix;

    }
}
