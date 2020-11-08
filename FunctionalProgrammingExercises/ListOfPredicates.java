package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int end = Integer.parseInt(scan.nextLine());

        List<Integer> divisible = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        BiFunction<List<Integer>, Integer, Boolean> predicate = ((list, n) -> {
            for (Integer integer : list) {
                if (n % integer != 0) {
                    return false;
                }
            }
            return true;
        });

        for (int i = 1; i <= end; i++) {
            if (predicate.apply(divisible, i)) {
                System.out.print(i + " ");
            }
        }
    }
}
