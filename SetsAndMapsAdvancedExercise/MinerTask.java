package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> resources = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("stop")) {
            int currentQty = Integer.parseInt(scan.nextLine());
            resources.putIfAbsent(input, 0);
            resources.put(input, resources.get(input) + currentQty);

            input = scan.nextLine();
        }
        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.println(String.format("%s -> %d", entry.getKey(), entry.getValue()));
        }
    }
}
