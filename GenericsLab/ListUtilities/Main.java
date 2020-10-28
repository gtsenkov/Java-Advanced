package GenericsLab.ListUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 54, 2, 75);

        System.out.println(ListUtils.getMax(numbers));
        System.out.println(ListUtils.getMin(numbers));
    }
}
