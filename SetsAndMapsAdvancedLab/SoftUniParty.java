package SetsAndMapsAdvancedLab;

import java.util.*;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> allGuests = new LinkedHashSet<>();
        Set<String> regularGuests = new TreeSet<>();
        Set<String> VIPGuests = new TreeSet<>();

        String input = scan.nextLine();
        while (!input.equals("PARTY")) {

            allGuests.add(input);
            input = scan.nextLine();
        }
        input = scan.nextLine();
        while (!input.equals("END")) {
            allGuests.remove(input);
            input = scan.nextLine();
        }

        System.out.println(allGuests.size());

        for (String guest : allGuests) {
            char firstLetter = guest.charAt(0);
            if (Character.isDigit(firstLetter)) {
                VIPGuests.add(guest);
            } else {
                regularGuests.add(guest);
            }

        }
        for (String vipGuest : VIPGuests) {
            System.out.println(vipGuest);
        }
        for (String regularGuest : regularGuests) {
            System.out.println(regularGuest);
        }

    }
}
