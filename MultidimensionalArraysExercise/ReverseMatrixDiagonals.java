package MultidimensionalArrays;

import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scan.nextInt();
            }
        }
        int counter = 0;
        for (int currentCol = cols - 1; currentCol >= 0; currentCol--) {
            for (int row = rows - 1, col = currentCol; row >= 0 && col < matrix[row].length;row--, col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        for (int currentRow = rows - 2; currentRow >= 0 ; currentRow--) {
            for (int col = 0, row = currentRow; col < cols && row >= 0; col++, row--) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();

        }
    }
}
