package JavaAdvancedRetakeExamAugust2020;

import java.util.Scanner;

public class Bee {
    static int flowersPollinated = 0;
    static int rowBee = 0;
    static int colBee = 0;
    static boolean isNewPosO = false;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        char[][] field = new char[n][n];

        for (int row = 0; row < n; row++) {
            String line = scan.nextLine();
            if (line.contains("B")) {
                rowBee = row;
                colBee = line.indexOf("B");
            }

            field[row] = line.toCharArray();
        }

        String command = scan.nextLine();

        boolean isGotLost = false;

        while (!command.equals("End") && !isGotLost) {

            switch (command) {
                case "up":
                    if (!isOutOfBounds(rowBee - 1, colBee, field)) {
                        moveBee(rowBee, colBee, rowBee - 1, colBee, field);
                    } else {
                        System.out.println("The bee got lost!");
                        field[rowBee][colBee] = '.';
                        isGotLost = true;
                    }
                    //row - 1
                    break;
                case "down":
                    if (!isOutOfBounds(rowBee + 1, colBee, field)) {
                        moveBee(rowBee, colBee, rowBee + 1, colBee, field);
                    } else {
                        System.out.println("The bee got lost!");
                        field[rowBee][colBee] = '.';
                        isGotLost = true;
                    }
                    //row + 1
                    break;
                case "left":
                    if (!isOutOfBounds(rowBee, colBee - 1, field)) {
                        moveBee(rowBee, colBee, rowBee, colBee - 1, field);
                    } else {
                        System.out.println("The bee got lost!");
                        field[rowBee][colBee] = '.';
                        isGotLost = true;
                    }
                    //col - 1
                    break;
                case "right":
                    if (!isOutOfBounds(rowBee, colBee + 1, field)) {
                        moveBee(rowBee, colBee, rowBee, colBee + 1, field);
                    } else {
                        System.out.println("The bee got lost!");
                        field[rowBee][colBee] = '.';
                        isGotLost = true;
                    }
                    //col + 1
                    break;
            }

            if (!isNewPosO  && !isGotLost) {
                command = scan.nextLine();
            }
        }

        int neededFlowers = 5 - flowersPollinated;

        if (flowersPollinated >= 5) {
            System.out.println("Great job, the bee manage to pollinate "
                    + flowersPollinated + " flowers!");
        } else {
            System.out.println("The bee couldn't pollinate the flowers, she needed "
            + neededFlowers + " flowers more");
        }

        printMatrix(field);
    }

    private static void moveBee(int currentRowBee, int currentColBee,
                                int newRow, int newCol, char[][] field) {
        if (field[newRow][newCol] == 'f') {
            isNewPosO = false;
            flowersPollinated++;
            field[currentRowBee][currentColBee] = '.';
            field[newRow][newCol] = 'B';
            rowBee = newRow;
            colBee = newCol;

        } else if (field[newRow][newCol] == 'O') {
            if (!isOutOfBounds(newRow, newCol, field)) {
                field[currentRowBee][currentColBee] = '.';
                field[newRow][newCol] = 'B';
                isNewPosO = true;
                rowBee = newRow;
                colBee = newCol;
            }
        } else if (field[newRow][newCol] == '.'){
            isNewPosO = false;
            field[currentRowBee][currentColBee] = '.';
            field[newRow][newCol] = 'B';
            rowBee = newRow;
            colBee = newCol;
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

        private static boolean isOutOfBounds(int row, int col, char[][] field) {
            return row < 0 || row >= field.length
                    || col < 0 || col >= field[row].length;
        }
}
