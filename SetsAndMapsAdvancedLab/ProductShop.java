package SetsAndMapsAdvancedLab;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Double>> productShop = new TreeMap<>();
        String[] input = scan.nextLine().split(", ");
        while (!input[0].equals("Revision")) {
            String market = input[0];
            String product = input[1];
            double price = Double.parseDouble(input[2]);
            productShop.putIfAbsent(market, new LinkedHashMap<>());
            productShop.get(market).putIfAbsent(product, price);

            input = scan.nextLine().split(", ");
        }
//        for (Map.Entry<String, Map<String, Double>> entry : productShop.entrySet()) {
//            System.out.println(entry.getKey() + "->");
//            for (Map.Entry<String, Double> subEntry : entry.getValue().entrySet()) {
//                System.out.println(String.format("Product: %s, Price: %.1f",
//                        subEntry.getKey(), subEntry.getValue()));
//            }
//        }
        productShop.forEach((key, value) -> {
            System.out.println(String.format("%s->", key));
            value.forEach((key1, value1) -> System.out.println(String.format("Product: %s, Price %.1f", key1, value1)));
        });
    }
}
