package GenericsExercise.GenericSwapMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        GenericsExercise.GenericSwapMethodString.Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
            String text = scan.nextLine();
            box.add(text);
        }

        String[] command = scan.nextLine().split(" ");

        int firstIndex = Integer.parseInt(command[0]);
        int secondIndex = Integer.parseInt(command[1]);

        if (firstIndex < box.length() && secondIndex < box.length() && firstIndex >= 0 && secondIndex >= 0) {
            box.swap(firstIndex, secondIndex);

        } else {
            throw new IndexOutOfBoundsException("Invalid indexes");
        }



        System.out.println(box);
    }
}
