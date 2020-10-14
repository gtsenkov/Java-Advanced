package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] values = Arrays.stream(scan.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> occurrence = new LinkedHashMap<>();

        for (double value : values) {
            if (!occurrence.containsKey(value)) {
                occurrence.put(value, 1);
            } else {
                occurrence.put(value, occurrence.get(value) + 1);
            }
        }

        for (Double key : occurrence.keySet()) {
            System.out.println(String.format("%.1f -> %d", key, occurrence.get(key)));
        }
    }
}
