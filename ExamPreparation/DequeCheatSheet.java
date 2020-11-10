package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DequeCheatSheet {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> queueFirstBox = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));



//        int[] stackBoxArr = Arrays.stream(scan.nextLine().split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .toArray();

        //updated reading from Marti
        ArrayDeque<Integer> stackSecondBox = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stackSecondBox::push);

    }

}
