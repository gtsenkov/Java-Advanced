package MultidimensionalArraysLab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int columns = Integer.parseInt(scan.nextLine());

        String separator = " ";
        char [][] matrixFirst = readCharMatrix(scan, rows, columns);
        char [][] matrixSecond = readCharMatrix(scan, rows, columns);
        char [][] resultMatrix = resultMatrix(matrixFirst, matrixSecond);
        for (int i = 0; i < resultMatrix.length ; i++) {
            for (int j = 0; j < resultMatrix[i].length ; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static char[][] readCharMatrix(Scanner scan, int rows, int columns) {
        char[][] matrix = new char[rows][columns];
        for (int row = 0; row < rows ; row++) {
            String[] matrixData = scan.nextLine().split(" ");
            for (int col = 0; col <columns ; col++) {
               matrix[row][col] = matrixData[col].charAt(0);
            }

        }return matrix;
    }
    private static char[][] resultMatrix(char[][] matrixFirst, char[][] matrixSecond) {
        char[][] matrix = new char[matrixFirst.length][matrixFirst[0].length];
        for (int row = 0; row < matrixFirst.length ; row++) {
            for (int col = 0; col <matrixFirst[row].length ; col++) {
                matrix[row][col] =
                        matrixFirst[row][col] == matrixSecond[row][col]
                        ?matrixFirst[row][col]
                        :'*';
            }
        }return matrix;
    }
}

