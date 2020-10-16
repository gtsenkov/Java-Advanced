package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> emails = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("stop")) {
            String address = scan.nextLine();
            String[] addressCountry = address.split("\\.");
            if (!addressCountry[1].equals("us") && !addressCountry[1].equals("uk") && !addressCountry[1].equals("com")) {
                emails.put(input, address);
            }
            input = scan.nextLine();
        }
        for (Map.Entry<String, String> entry : emails.entrySet()) {
            System.out.println(String.format("%s -> %s", entry.getKey(), entry.getValue()));
        }
    }
}
