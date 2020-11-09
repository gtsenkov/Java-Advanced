package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        List<String> invited = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String commands = scan.nextLine();

        Predicate<Character> startsWithCriteria = e -> {
            String current = "";
            for (String s : invited) {
                current = s;
                return s.charAt(0) == e;
            }
            return false;
        };

        while (!commands.equals("Party!")) {
            String[] tokens = commands.split("\\s+");

            String command = tokens[0];
            String predicateType = tokens[1];
            String predicateArgument = tokens[2];

            switch (tokens[0]) {
                case "Remove":
                    invited.removeIf(getPredicate(predicateType, predicateArgument));
                    break;
                case "Double":
                    for (int i = 0; i < invited.size(); i++) {
                        String guest = invited.get(i);
                        if (getPredicate(predicateType, predicateArgument).test(guest)) {
                            invited.add(i++, guest);
                        }
                    }
                    break;
            }
            commands = scan.nextLine();
        }
        if (invited.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(invited);
            System.out.println(String.format("%s are going to the party!",
                    String.join(", ", invited)));
        }
    }

    private static Predicate<? super String> getPredicate(String predicateType, String predicateArgument) {
        switch (predicateType) {
            case "StartsWith":
                return text -> text.startsWith(predicateArgument);
            case "EndsWith":
                return text -> text.endsWith(predicateArgument);
            case "Length":
                return text -> text.length() == Integer.parseInt(predicateArgument);
            default:
                return text -> false;
        }
    }
}

