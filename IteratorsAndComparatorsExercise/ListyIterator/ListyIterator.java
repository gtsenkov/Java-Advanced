package IteratorsAndComparatorsExercise.ListyIterator;

import java.util.ArrayList;
import java.util.List;

public class ListyIterator {
    private List<String> stringList;
    private int index;

    public ListyIterator(List<String> data) {
        this.stringList = data;
        this.setIndex(index);
    }

    public void setIndex(int index) {
        if (this.stringList.size() == 0) {
            this.index = -1;
        } else {
            this.index = 0;
        }
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
        if (this.index == -1) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(stringList.get(this.index));
        }
    }

    public boolean hasNext() {
        if (indexValidation(this.index)) {
            if (this.index + 1 < stringList.size()) {
                return true;
            }
        } return false;
    }
}
