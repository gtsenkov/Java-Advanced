package GenericsExercise.GenericCountMethodString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Box<T extends Comparable<T>>  {

    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        this.values.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : this.values) {
            sb.append(String.format("%s: %s", value.getClass().getName(), value));
            sb.append(System.lineSeparator());

        }
        return sb.toString();
    }

    public int compare(T comparable) {
        return (int) this.values.stream().filter(e -> e.compareTo(comparable) > 0.).count();
    }
}
