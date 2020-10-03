package MultidimensionalArrays;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double playerHit = Double.parseDouble(scan.nextLine());
        double heiganLife = 3000000.0;
        int playerLife = 18500;
        int currentRow = 7;
        int currentCol = 7;
        String repeatCloud = "";
        String spell = "";
        while (true) {
            int[][] chamberMatrix = new int[15][15];
            if (heiganLife > 0) {
                heiganLife -= playerHit;
            }
            if (repeatCloud.equals("hit") ) {
                playerLife -= 3500;
            }
            if (heiganLife <= 0 || playerLife <= 0) {
                break;
            }
            String[] commands = scan.nextLine().split(" ");
            spell = commands[0];
            int rowToDamage = Integer.parseInt(commands[1]);
            int colToDamage = Integer.parseInt(commands[2]);

            for (int rowDamage = rowToDamage - 1; rowDamage <= rowToDamage + 1; rowDamage++) {
                for (int colDamage = colToDamage - 1; colDamage <= colToDamage + 1; colDamage++) {
                    if (isValid(chamberMatrix, rowDamage, colDamage) && chamberMatrix[rowDamage][colDamage] != 1) {
                        chamberMatrix[rowDamage][colDamage] = 1;
                    }
                }
            }
            if (chamberMatrix[currentRow][currentCol] == 1) {

                if (currentRow - 1 >= 0 && chamberMatrix[currentRow - 1][currentCol] == 0) {
                    currentRow = currentRow - 1;
                    spell = "";
                } else if (currentCol + 1 < chamberMatrix.length && chamberMatrix[currentRow][currentCol + 1] == 0) {
                    currentCol = currentCol + 1;
                    spell = "";
                } else if (currentRow + 1 < chamberMatrix.length && chamberMatrix[currentRow + 1][currentCol] == 0) {
                    currentRow = currentRow + 1;
                    spell = "";
                } else if (currentCol - 1 >= 0 && chamberMatrix[currentRow][currentCol - 1] == 0) {
                    currentCol = currentCol - 1;
                    spell = "";
                }
            }

            //matrixPrint(chamberMatrix);
            if (chamberMatrix[currentRow][currentCol] == 1 && heiganLife > 0) {
                switch (spell) {
                    case "Cloud":
                        spell = "Plague Cloud";
                        playerLife -= 3500;
                        repeatCloud = "hit";
                        break;
                    case "Eruption":
                        playerLife -= 6000;
                        break;
                }
            }
        }
        if (playerLife <= 0) {
            System.out.printf("Heigan: %.2f%n", heiganLife);
            System.out.printf("Player: Killed by %s%n", spell);
            System.out.printf("Final position: %d, %d%n", currentRow, currentCol);
        } else if (heiganLife <= 0) {
            System.out.println("Heigan: Defeated!");
            System.out.printf("Player: %d%n", playerLife);
            System.out.printf("Final position: %d, %d%n", currentRow, currentCol);
        }
    }

    private static void matrixPrint(int[][] chamberMatrix) {
        for (int[] matrix : chamberMatrix) {
            for (int i : matrix) {
                System.out.print(i);
            }
            System.out.println();
        }
    }


    private static boolean isValid(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
