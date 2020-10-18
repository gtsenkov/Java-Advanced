package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> users = new LinkedHashSet<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String currentUser = scan.nextLine();
            users.add(currentUser);
        }
        for (String user : users) {
            System.out.println(user);
        }
    }
}
