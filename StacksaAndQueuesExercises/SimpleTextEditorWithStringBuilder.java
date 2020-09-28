package StacksaAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditorWithStringBuilder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        int n = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> history = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] command = scan.nextLine().split(" ");
            switch (command[0]) {
                case "1":
                    history.push(command[1]);
                    output.append(history.peek());
                    break;
                case "2":
                    if (!history.isEmpty()) {
                        int count = Integer.parseInt(command[1]);
                        String updatedText = "";
                        for (int j = 0; j < count ; j++) {
                          // try {
                                updatedText = output.deleteCharAt(output.length() - 1).toString();
                          //  } catch (Exception e) {

                           // }
                        }
                        history.push(updatedText);
                    }
                    break;
                case "3":
                    if (!history.isEmpty()) {
                        try {
                            System.out.println(history.peek().charAt(Integer.parseInt(command[1]) - 1));
                        } catch (Exception e) {

                        }
                    }
                    break;
                case "4":
                    if (!history.isEmpty()) {
                        history.pop();
                    }
                    break;
            }

        }
    }
}
