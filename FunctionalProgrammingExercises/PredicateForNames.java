package FunctionalProgrammingExercises;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int maxLength = Integer.parseInt(scan.nextLine());

        String[] names = scan.nextLine().split("\\s+");

        Predicate<String> validName = name -> name.length() <= maxLength;

        Arrays.stream(names).filter(validName).forEach(System.out::println);

//        for (String name : names) {
//            if (validName.test(name)) {
//                System.out.println(name);
//            }
//        }
    }
}
