package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        UnaryOperator<Double> vatAdder = priceWithoutVat -> priceWithoutVat * 1.20;
        System.out.println("Prices with VAT:");

        Arrays.stream(scan.nextLine().split(", "))
                .mapToDouble(e -> vatAdder.apply(Double.parseDouble(e)))
                .forEach(e -> System.out.printf("%.2f%n", e));
    }
}
