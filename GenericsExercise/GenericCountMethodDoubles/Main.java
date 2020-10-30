package GenericsExercise.GenericCountMethodDoubles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Box<Double> box = new Box<>();
        for (int i = 0; i < n; i++) {
            Double text = Double.parseDouble(scan.nextLine());
            box.add(text);
        }

        Double comparable = Double.parseDouble(scan.nextLine());

        int count = box.compare(comparable);

        System.out.println(count);
    }
}
