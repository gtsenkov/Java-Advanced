package FunctionalProgrammingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Main { //FilterByAge

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());


        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] tokens = scan.nextLine().split(", ");

            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));

            people.add(person);
        }

        String orderCriteria = scan.nextLine();

        int ageCriteria = Integer.parseInt(scan.nextLine());

        Predicate<Person> ageFilter = createAgeFilter(orderCriteria, ageCriteria);

        String formatOption = scan.nextLine();

        Function<Person, String> formatter = createFormatter(formatOption);


        System.out.println(people.stream()
                .filter(ageFilter)
                .map(formatter)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static Function<Person, String> createFormatter(String formatOption) {
        if (formatOption.equals("name")) {
            return Person::getName;
        } else if (formatOption.equals("age")) {
            return p -> String.valueOf(p.getAge());
        }

        return p -> p.getName() + " - " + p.getAge();
    }

    private static Predicate<Person> createAgeFilter(String orderCriteria, int ageCriteria) {
        if (orderCriteria.equals("older")) {
            return p -> p.getAge() >= ageCriteria;
        }
        return p -> p.getAge() <= ageCriteria;
    }
}
