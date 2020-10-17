package SetsAndMapsAdvancedExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> phoneBook = new HashMap<>();
        String input = scan.nextLine();

        while (!input.equals("search")) {
            String[] tokens = input.split("-");

            String name = tokens[0];
            String phone = tokens[1];

            phoneBook.put(name, phone);

            input = scan.nextLine();
        }
        input = scan.nextLine();
        while (!input.equals("stop")) {
            if (phoneBook.containsKey(input)) {
                System.out.println(String.format("%s -> %s",input, phoneBook.get(input)));
            } else {
                System.out.println(String.format("Contact %s does not exist.", input));
            }

            input = scan.nextLine();
        }
    }
}

