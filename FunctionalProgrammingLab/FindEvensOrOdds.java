package FunctionalProgrammingLab;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] range = scan.nextLine().split(" ");

        int lowerBound = Integer.parseInt(range[0]);
        int upperBound = Integer.parseInt(range[1]);

        String criteria = scan.nextLine();

        Predicate<Integer> numberState = getCriteria(criteria);

        for (int i = lowerBound; i <= upperBound ; i++) {
            if (numberState.test(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static Predicate<Integer> getCriteria(String criteria) {
        if (criteria.equals("odd")) {
            return num -> num % 2 != 0;
        } return num -> num % 2 == 0;
    }
}
