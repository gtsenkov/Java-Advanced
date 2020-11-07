package FunctionalProgrammingExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scan.nextLine();

        UnaryOperator<int[]> add = arr -> Arrays.stream(arr)
                .map(e -> e += 1)
                .toArray();

        UnaryOperator<int[]> multiply = arr -> Arrays.stream(arr)
                .map(e -> e *= 2)
                .toArray();

        UnaryOperator<int[]> subtract = arr -> Arrays.stream(arr)
                .map(e -> e -= 1)
                .toArray();

        Consumer<int[]> print = arr -> Arrays.stream(arr).forEach(e -> System.out.print(e + " "));

        while (!command.equals("end")) {

            switch (command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
            }

            command = scan.nextLine();
        }



    }
}
