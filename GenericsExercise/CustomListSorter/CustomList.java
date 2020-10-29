package GenericsExercise.CustomListSorter;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> values;

    public CustomList() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        this.values.add(element);
    }

    public T remove(int index) {
        if (index < 0 || this.values.size() < index) {
            throw new IndexOutOfBoundsException("Invalid index");
        } else {
            return this.values.remove(index);

        }
    }

    public boolean contains(T element) {
        return this.values.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        if (validateIndex(firstIndex, this.values) && validateIndex(secondIndex, this.values)) {
//            // Collections.swap(this.values, firstIndex, secondIndex);

            T firstElement = this.values.get(firstIndex);
            T secondElement = this.values.get(secondIndex);

            this.values.set(firstIndex, secondElement);
            this.values.set(secondIndex, firstElement);
        } else {
            throw new IndexOutOfBoundsException("Invalid index!");
        }
    }

    private boolean validateIndex(int index, List<T> values) {
        if (index >= 0 && index < values.size()) {
            return true;
        }
        return false;
    }

    public int countGreaterThan(T element) {
        return (int) this.values.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T max() {
        // return Collections.max(this.values);
        if (this.values.isEmpty()) {
            throw new IllegalStateException("Empty list");
        }
        T max = this.values.get(0);
        for (int i = 1; i < this.values.size(); i++) {
            T current = this.values.get(i);
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }

    public T min() {
        // return Collections.min(this.values);
        if (this.values.isEmpty()) {
            throw new IllegalStateException("Empty list");
        }
        T min = this.values.get(0);
        for (int i = 1; i < this.values.size(); i++) {
            T current = this.values.get(i);
            if (current.compareTo(min) < 0) {
                min = current;
            }
        }
        return min;
    }

    public T get(int index) {
        return this.values.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.values.size(); i++) {
            sb.append(values.get(i));
            if (i + 1 < this.values.size()) {
                sb.append(System.lineSeparator());
            }
        }

//        for (T value : this.values) {
//            sb.append(value);
//            if (values.listIterator().hasNext()) {
//                sb.append(System.lineSeparator());
//            }
//        }

        return sb.toString();
    }

    public int size() {
        return this.values.size();
    }
}
