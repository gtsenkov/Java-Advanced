package SetsAndMapsAdvancedExercise;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> chemicalElements = new TreeSet<>();
        int cycles = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < cycles; i++) {
            String[] compound = scan.nextLine().split(" ");
            for (int j = 0; j < compound.length; j++) {
                String currentElement = compound[j];
                chemicalElements.add(currentElement);
            }
        }
        for (String chemicalElement : chemicalElements) {
            System.out.print(chemicalElement + " ");
        }
    }
}
