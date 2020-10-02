package MultidimensionalArrays;

import java.util.Scanner;

public class MatrixShuffling {
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
        String nextRow = scan.nextLine();
        String[] command = scan.nextLine().split(" ");
        while (!command[0].equals("END") ) {
            if (command.length != 5 || !command[0].equals("swap") || !indexIsInvalid(matrix, command[1], command[2], command[3], command[4])) {
                System.out.println("Invalid input!");
                command = scan.nextLine().split(" ");
                continue;
            }

            int tempElement = matrix[Integer.parseInt(command[1])][Integer.parseInt(command[2])];
            matrix[Integer.parseInt(command[1])][Integer.parseInt(command[2])] = matrix[Integer.parseInt(command[3])][Integer.parseInt(command[4])];
            matrix[Integer.parseInt(command[3])][Integer.parseInt(command[4])] = tempElement;
            for (int[] ints : matrix) {
                for (int num : ints) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            command = scan.nextLine().split(" ");
        }
    }

    private static boolean indexIsInvalid(int[][] matrix, String row1, String col1, String row2, String col2) {
        int row1Num = Integer.parseInt(row1);
        int col1Num = Integer.parseInt(col1);
        int row2Num = Integer.parseInt(row2);
        int col2Num = Integer.parseInt(col2);
        return row1Num >= 0 && row1Num < matrix.length && row2Num >= 0 && row2Num < matrix.length && col1Num >= 0 && col1Num < matrix.length && col2Num >= 0 && col2Num < matrix.length;
    }
}
