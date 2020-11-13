package JavaAdvancedExamFeb2020;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class ReVolt {
    static int currentRowCar = -1;
    static int currentColCar = -1;
    static boolean isFinished = false;
    static int newRowCar;
    static int newColCar;
    static String currentCommand;


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int numberCommands = Integer.parseInt(scan.nextLine());

        char[][] field = new char[n][n];

        for (int row = 0; row < n; row++) {
            String line = scan.nextLine();
            if (line.contains("f")) {
                currentRowCar = row;
                currentColCar = line.indexOf("f");
            }
            field[row] = line.toCharArray();
        }

        for (int i = 0; i < numberCommands; i++) {

            currentCommand = scan.nextLine();

            moveSetter(currentRowCar, currentColCar, field, currentCommand);

            if (isFinished) {
                System.out.println("Player won!");
                printMatrix(field);
                return;
            }
        }

        System.out.println("Player lost!");
        printMatrix(field);
    }

    private static void moveSetter(int currRowCar, int currColCar, char[][] field, String command) {
        switch (command) {
            case "up":
                if (isOutOfBounds(currRowCar - 1, currColCar, field)) {

                   // field[currRowCar][currColCar] = '-';
                    newRowCar = field[currRowCar].length - 1;
                    newColCar = currColCar;
                }
                else {
                    newRowCar = currRowCar - 1;
                    newColCar = currColCar;
                }
                if (field[currRowCar][currColCar] != 'B') {
                    field[currRowCar][currColCar] = '-';
                }
                moveChecker(currRowCar, currColCar, newRowCar, newColCar, field);
                //row - 1
                break;
            case "down":
                if (isOutOfBounds(currRowCar + 1, currColCar, field)) {

                  //  field[currRowCar][currColCar] = '-';
                    newRowCar = 0;
                    newColCar = currColCar;
                } else {
                    newRowCar = currRowCar + 1;
                    newColCar = currColCar;
                }
                if (field[currRowCar][currColCar] != 'B') {
                    field[currRowCar][currColCar] = '-';
                }

                moveChecker(currRowCar, currColCar, newRowCar, newColCar, field);
                //row + 1
                break;
            case "left":
                if (isOutOfBounds(currRowCar, currColCar - 1, field)) {

                  //  field[currRowCar][currColCar] = '-';
                    newRowCar = currRowCar;
                    newColCar = field[currColCar].length -1;
                } else {
                    newRowCar = currRowCar;
                    newColCar = currColCar - 1;
                }
                if (field[currRowCar][currColCar] != 'B') {
                    field[currRowCar][currColCar] = '-';
                }
                moveChecker(currRowCar, currColCar, newRowCar, newColCar, field);
                //col - 1
                break;
            case "right":
                if (isOutOfBounds(currRowCar, currColCar + 1, field)) {
//                    if (field[currRowCar][currColCar] != 'B') {
//                        field[currRowCar][currColCar] = '-';
//                    }
                   // field[currRowCar][currColCar] = '-';
                    newRowCar = currRowCar;
                    newColCar = 0;
                } else {
                    newRowCar = currRowCar;
                    newColCar = currColCar + 1;
                }
                if (field[currRowCar][currColCar] != 'B') {
                    field[currRowCar][currColCar] = '-';
                }
                moveChecker(currRowCar, currColCar, newRowCar, newColCar, field);
                //col + 1
                break;
        }
        if (field[currRowCar][currColCar] != 'B') {
            field[currRowCar][currColCar] = '-';
            field[newRowCar][newColCar] = 'f';
        }
    }

    private static boolean moveChecker(int currRowCar, int currColCar, int toMoveRowCar, int toMoveColCar, char[][] field) {

        if (field[toMoveRowCar][toMoveColCar] == 'B') {
        moveSetter(toMoveRowCar, toMoveColCar, field, currentCommand);
            currentRowCar = newRowCar;
            currentColCar = newColCar;
            return isFinished;
        } else if (field[toMoveRowCar][toMoveColCar] == 'T') {
            //moveSetter(toMoveRowCar, toMoveColCar, field, getOppositeCommand(currentCommand));
//            currentRowCar = newRowCar;
//            currentColCar = newColCar;
            newRowCar = currentRowCar;
            newColCar = currentColCar;
            return isFinished;
        } else if (field[toMoveRowCar][toMoveColCar] == '-') {
            currentRowCar = newRowCar;
            currentColCar = newColCar;
            return isFinished;
        } else if(field[toMoveRowCar][toMoveColCar] == 'F'){
            if (field[currRowCar][currColCar] != 'B') {
                field[currRowCar][currColCar] = '-';
            }
           // field[currRowCar][currColCar] = '-';
            field[toMoveRowCar][toMoveColCar] = 'f';
            return isFinished = true;
        }
//        field[currRowCar][currColCar] = '-';
//        field[toMoveRowCar][toMoveColCar] = 'f';
        return isFinished;
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

//    public static String getOppositeCommand(String currentCommand) {
//        switch (currentCommand) {
//            case "up":
//                return "down";
//            case "down":
//                return "up";
//            case "left":
//                return "right";
//            case "right":
//                return "left";
//        }
//        return "";
//    }
}
