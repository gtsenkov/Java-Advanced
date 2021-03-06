package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Comparator<Integer> sorter = ((a, b) ->{
            if (a % 2 == 0 && b % 2 == 0) {
                return a.compareTo(b);
            } else if (a % 2 == 0 && b % 2 != 0) {
                return  -1;
            } else if (a % 2 != 0 && b % 2 == 0) {
                return 1;
            }
            return a.compareTo(b);
        });

        numbers.stream().sorted(sorter).forEach(e -> System.out.print(e + " "));
    }
}
