package Exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Garden {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputSize = scan.nextLine().split("\\s+");
        int size = Integer.parseInt(inputSize[0]);

        int[][] garden = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size ; col++) {
                garden[row][col] = 0;

            }
        }

        String command = scan.nextLine();

        List<List<Integer>> plantedFlowers = new ArrayList<>();
        int planedPlaces = 0;

        while (!command.equals("Bloom Bloom Plow")) {
            String[] inputPlant = command.split("\\s+");
            int rowToPlant = Integer.parseInt(inputPlant[0]);
            int colToPlant = Integer.parseInt(inputPlant[1]);
            if (isOutOfBounds(rowToPlant, colToPlant, garden)) {
                System.out.println("Invalid coordinates.");
            } else {
                garden[rowToPlant][colToPlant] = 1;
                plantedFlowers.add(planedPlaces, new ArrayList<>());
                plantedFlowers.get(planedPlaces).add(rowToPlant);
                plantedFlowers.get(planedPlaces).add(colToPlant);
                planedPlaces++;
            }

            command = scan.nextLine();
        }

        for (List<Integer> plantedFlower : plantedFlowers) {

            int rowToBloom = plantedFlower.get(0);
            int colToBloom = plantedFlower.get(1);

            bloom(rowToBloom, colToBloom, garden);
        }


        printMatrix(garden);
    }

    private static void bloom(int rowToBloom, int colToBloom, int[][] garden) {
        for (int i = rowToBloom + 1; i < garden.length; i++) {
            garden[i][colToBloom] = garden[i][colToBloom] + 1;
        }
        for (int i = rowToBloom - 1; i >= 0 ; i--) {
            garden[i][colToBloom] = garden[i][colToBloom] + 1;
        }
        for (int i = colToBloom + 1; i < garden.length; i++) {
            garden[rowToBloom][i] = garden[rowToBloom][i] + 1;
        }
        for (int i = colToBloom - 1; i >= 0 ; i--) {
            garden[rowToBloom][i] = garden[rowToBloom][i] + 1;
        }

    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isOutOfBounds(int row, int col, int[][] field) {
        return row < 0 || row >= field.length
                || col < 0 || col >= field[row].length;
    }
}
