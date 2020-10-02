package MultidimensionalArrays;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();

        char startLetterRow = 'a';
        char startLetterCol = 'a';

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print("" + ((char)(startLetterRow + row)) + ((char)(startLetterCol + col)) + ((char)(startLetterRow + row)) + " ");
            }
            System.out.println();
            startLetterCol++;
        }
    }
}
