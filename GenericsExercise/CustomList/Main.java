package GenericsExercise.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();

        String[] command = scan.nextLine().split("\\s+");
        while (!command[0].equals("END")) {
            switch (command[0]) {
                case "Add":
                    customList.add(command[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(command[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(command[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(command[1]));
                    break;
                case "Max":
                    System.out.println(customList.max());
                    break;
                case "Min":
                    System.out.println(customList.min());
                    break;
                case "Print":
                    System.out.println(customList);
                    break;
//                case "Sort":
//                 CustomListSorter.sort(customList);
//                 break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
            command = scan.nextLine().split("\\s+");
        }

    }
}
