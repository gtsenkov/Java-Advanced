package IteratorsAndComparatorsExercise.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        String input = scan.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            Person person = new Person(name, age, town);

            people.add(person);

            input = scan.nextLine();
        }

        int n = Integer.parseInt(scan.nextLine());

        int equals = 0;

        Person personToCompare = people.get(n - 1);


        for (Person person : people) {
            if (person.compareTo(personToCompare) == 0) {
                equals++;
            }
        }

        if (equals == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(equals + " "
                    + (people.size() - equals + " " + people.size()));
        }
    }
}
