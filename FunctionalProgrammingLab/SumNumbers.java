package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], String> getCount =
                arr -> String.format("Count = %d", arr.length);

        System.out.println(getCount.apply(numbers));

        Function<int[], String> getArrSum =
                arr -> "Sum = " + Arrays.stream(arr).sum();

        System.out.println(getArrSum.apply(numbers));
    }
}
