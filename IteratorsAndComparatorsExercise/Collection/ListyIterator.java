package IteratorsAndComparatorsExercise.Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> stringList;
    private int index;

    ListyIterator(List<String> data) {
        this.stringList = data;
        int index = 0;
    }

    public boolean indexValidation(int index) {
        return index >= 0 && index < this.stringList.size();
    }

    public boolean move() {
        if (indexValidation(this.index)) {
            if (this.index + 1 < stringList.size()) {
                this.index++;
                return true;
            }
        } return false;
    }

    public void print() {
        if (stringList.isEmpty()) {
            throw new IndexOutOfBoundsException("Invalid Operation!");
        }
        System.out.println(stringList.get(this.index));
    }

    public boolean hasNext() {
        if (indexValidation(this.index)) {
            if (this.index + 1 < stringList.size()) {
                return true;
            }
        } return false;
    }

    public void printAll() {
        if (indexValidation(this.index)) {
            for (String s : stringList) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                if (indexValidation(index)) {
                    if (index + 1 < stringList.size()) {
                        return true;
                    }
                } return false;
            }

            @Override
            public String next() {
                if (indexValidation(index)) {
                    move();
                }return stringList.get(index);
            }
        };
    }
}
