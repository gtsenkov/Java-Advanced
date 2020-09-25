package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> printer = new ArrayDeque<>();
        String task = scan.nextLine();

        while (!task.equals("print")) {
            if (!task.equals("cancel")) {
                printer.offer(task);
            } else {
                if (!printer.isEmpty()) {
                    System.out.println("Canceled " + printer.poll());
                } else {
                    System.out.println("Printer is on standby");
                }

            }
            task = scan.nextLine();
        }
        while (!printer.isEmpty()) {
            System.out.println(printer.poll());
        }
    }
}
