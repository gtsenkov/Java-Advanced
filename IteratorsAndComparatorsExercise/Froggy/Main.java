package IteratorsAndComparatorsExercise.Froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        while (!input.equals("END")) {
            int[] stones = Arrays.stream(input.split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            Lake lake = new Lake(stones);
            Iterator it = lake.iterator();

            StringBuilder builder = new StringBuilder();

            while (it.hasNext()) {
                builder.append(it.next()).append(", ");
            }

            System.out.println(builder.toString().substring(0, builder.toString().lastIndexOf(", ")));

            input = scan.nextLine();
        }

    }
}
