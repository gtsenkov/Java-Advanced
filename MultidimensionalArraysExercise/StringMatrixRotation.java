package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int command = Integer.parseInt(scan.nextLine().split("[()]+")[1]) % 360;
        String input = scan.nextLine();
        int maxLength = input.length();
        List<String> inputList = new ArrayList<>();
        while (!input.equals("END")) {
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
            inputList.add(input);
            input = scan.nextLine();
        }
        int rows = inputList.size();
        int cols = maxLength;

        char[][] matrix = new char[inputList.size()][maxLength];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < inputList.get(row).length()) {
                    matrix[row][col] = inputList.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        switch (command) {
            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = rows - 1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 0:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }

    }
}
