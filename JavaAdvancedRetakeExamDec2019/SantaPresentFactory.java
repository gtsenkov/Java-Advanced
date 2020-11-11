package JavaAdvancedRetakeExamDec2019;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

public class SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] stackBoxArr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stackMaterialBox = new ArrayDeque<>();
        for (Integer integerLily : stackBoxArr) {
            stackMaterialBox.push(integerLily);
        }

        ArrayDeque<Integer> queueMagicLevel = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));



        Map<String, Integer> craftedPresents = new TreeMap<>();

        int crafting = 0;

        while (!queueMagicLevel.isEmpty() && !stackMaterialBox.isEmpty()) {
            int magic = queueMagicLevel.peek();
            int material = stackMaterialBox.peek();
            crafting = magic * material;
            if (magic == 0 || material == 0) {
                if (magic == 0) {
                    queueMagicLevel.poll();
                }
                else if (material == 0) {
                    stackMaterialBox.pop();
                }
            } else if (crafting < 0) {
                int sum = magic + material;
                stackMaterialBox.pop();
                queueMagicLevel.poll();
                stackMaterialBox.push(sum);
            } else if (crafting == 150) {
                craftedPresents.putIfAbsent("Doll", 0);
                craftedPresents.put("Doll", craftedPresents.get("Doll") + 1);
                stackMaterialBox.pop();
                queueMagicLevel.poll();
            } else if (crafting == 250) {
                craftedPresents.putIfAbsent("Wooden train", 0);
                craftedPresents.put("Wooden train", craftedPresents.get("Wooden train") + 1);
                stackMaterialBox.pop();
                queueMagicLevel.poll();
            } else if (crafting == 300) {
                craftedPresents.putIfAbsent("Teddy bear", 0);
                craftedPresents.put("Teddy bear", craftedPresents.get("Teddy bear") + 1);
                stackMaterialBox.pop();
                queueMagicLevel.poll();
            } else if (crafting == 400) {
                craftedPresents.putIfAbsent("Bicycle", 0);
                craftedPresents.put("Bicycle", craftedPresents.get("Bicycle") + 1);
                stackMaterialBox.pop();
                queueMagicLevel.poll();
            } else {
                queueMagicLevel.poll();
                int increasingValue = stackMaterialBox.pop() + 15;
                stackMaterialBox.push(increasingValue);
            }
        }

        if ((craftedPresents.containsKey("Doll") && craftedPresents.containsKey("Wooden train"))
                || (craftedPresents.containsKey("Teddy bear") && craftedPresents.containsKey("Bicycle"))) {

            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!stackMaterialBox.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.println(stackMaterialBox.toString().replaceAll("[\\[\\]]", ""));
        }
        if (!queueMagicLevel.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.println(queueMagicLevel.toString().replaceAll("[\\[\\]]", ""));
        }

        for (Map.Entry<String, Integer> entry : craftedPresents.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
