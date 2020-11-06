package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] numbers = scan.nextLine().split(", ");

        String output = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(output);

        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .sorted()
                .forEach(e -> stringBuilder.append(e).append(", "));

        System.out.println(stringBuilder.subSequence(0, stringBuilder.lastIndexOf(",")));

    }
}
