package SetsAndMapsAdvancedLab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, ArrayList<String>>> map = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n ; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String continent = data[0];
            String country = data[1];
            String city = data[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country, new ArrayList<>());
            map.get(continent).get(country).add(city);
        }
        for (Map.Entry<String, Map<String, ArrayList<String>>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Map.Entry<String, ArrayList<String>> subEntry : entry.getValue().entrySet()) {
                System.out.println("  " + subEntry.getKey() + " -> " +
                        String.join(", ", subEntry.getValue()));
            }
        }
    }
}
