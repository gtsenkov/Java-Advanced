package ExamPreparation;

import java.util.Scanner;

public class MatrixCheatSheet {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    //Reading
    int size = Integer.parseInt(scan.nextLine());

    char[][] field = new char[size][size];

    int rowPlayer = 0;
    int colPlayer =0;

        for (int row = 0; row < size; row++) {
        String line = scan.nextLine();
        if (line.contains("f")) {
            rowPlayer = row;
            colPlayer = line.indexOf("f");
        }
        field[row] = line.toCharArray();
    }



    //MOVING && CORE LOGIC

    String command = scan.nextLine();
        while (!command.equals("Something")) {

        if (command.equals("up")) {
            // row - 1
            if (isOutOfBounds(rowPlayer - 1, colPlayer, field)) {
                break;//if you want to stop While cycle
            } else {
                rowPlayer--;
                //do something in addition (can be with general method)
            }
        } else if (command.equals("down")) {
            // row + 1
            if (isOutOfBounds(rowPlayer + 1, colPlayer, field)) {
                break;
            } else {
                rowPlayer++;
            }
        } else if (command.equals("left")) {
            // col - 1
            if (isOutOfBounds(rowPlayer, colPlayer - 1, field)) {
                break;
            } else {
                colPlayer--;
            }
        } else if (command.equals("right")) {
            // col + 1
            if (isOutOfBounds(rowPlayer, colPlayer + 1, field)) {
                break;
            } else {
                colPlayer++;
            }
        }
        command = scan.nextLine();
    }

    printMatrix(field);
}

    private static boolean isOutOfBounds(int row, int col, char[][] field) {
        return row < 0 || row >= field.length
                || col < 0 || col >= field[row].length;
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(int row, int col, char[][] field) {
        return !isOutOfBounds(row, col, field);
    }
}
