package SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputQty = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> studentGrades = new TreeMap<>();

        for (int i = 0; i < inputQty ; i++) {
            String[] input = scan.nextLine().split(" ");

            String student = input[0];
            double grade = Double.parseDouble(input[1]);

            studentGrades.putIfAbsent(student, new ArrayList<>());
            studentGrades.get(student).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : studentGrades.entrySet()) {
            System.out.println(String.format("%s -> %s (avg: %.2f)", entry.getKey(),
                    getGradesAsString(entry.getValue()), getAvg(entry.getValue())));
        }
    }

    private static Double getAvg(List<Double> grades) {
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    private static String getGradesAsString(List<Double> value) {
        return value.stream()
                .map(grade -> String.format("%.2f", grade))
                .collect(Collectors.joining(" "));
    }
}
