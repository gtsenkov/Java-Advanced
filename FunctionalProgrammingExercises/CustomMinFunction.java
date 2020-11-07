package FunctionalProgrammingExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> getMin = arrNumbers -> Arrays.stream(arrNumbers)
                .min().getAsInt();

        System.out.println(getMin.apply(numbers));

    }
}
