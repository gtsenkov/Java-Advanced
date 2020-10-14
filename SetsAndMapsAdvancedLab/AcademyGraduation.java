package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Double> graduationList = new TreeMap<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n  ; i++) {
            String name = scan.nextLine();
            double avg = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).average().orElse(0);
            graduationList.put(name, avg);
        }

        for (Map.Entry<String, Double> entry : graduationList.entrySet()) {
            System.out.println(entry.getKey() + " is graduated with " + entry.getValue());
        }
    }
}
