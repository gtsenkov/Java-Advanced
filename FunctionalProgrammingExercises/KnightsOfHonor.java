package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        Consumer<String[]> printNames = names -> Arrays.stream(names).forEach(name -> System.out.println("Sir " + name));

        printNames.accept(input);
    }
}
