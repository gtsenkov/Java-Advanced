package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Consumer<List<Integer>> findIndexOfMinElement = list -> System.out.println(list.lastIndexOf(Collections.min(list)));
        findIndexOfMinElement.accept(numbers);

//        Function<List<Integer>, Integer> findIndexOfSmallest = list -> {
//            int min = Collections.min(list);
//            return list.lastIndexOf(min);
//        };
//
//        System.out.println(findIndexOfSmallest.apply(numbers));
    }
}

