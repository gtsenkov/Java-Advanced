package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        int divisibleBy = Integer.parseInt(scan.nextLine());

        Predicate<Integer> areDivisible = number -> number % divisibleBy == 0;
        Consumer<List<Integer>> print = list -> list.forEach(e -> System.out.print(e + " "));
        numbers.removeIf(areDivisible);
        Collections.reverse(numbers);
        print.accept(numbers);
    }
}
