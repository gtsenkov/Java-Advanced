package IteratorsAndComparatorsExercise.Froggy;

import java.util.Iterator;

public class Lake implements Iterable {
    private int[] stones;

    public Lake(int[] stones) {
        this.stones = stones;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<Integer>() {
            private int index = 0;
            private int lastEvenIndex = stones.length % 2 == 0 ? stones.length - 2 : stones.length -1;

            @Override
            public boolean hasNext() {
                return this.index < stones.length;
            }

            @Override
            public Integer next() {
                if (this.index == lastEvenIndex) {
                    int element = stones[lastEvenIndex];
                    this.index = 1;
                    return element;
                }

                int element = stones[index];
                this.index += 2;
                return element;
            }
        };
    }
}
