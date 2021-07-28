package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenNumbersIterator(final int[] numbers) {
        this.data = numbers;
    }

    @Override
    public boolean hasNext() {
        return getIndexOfEvenNumber(data, point) != -1;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }

    private int getIndexOfEvenNumber(int[] data, int pos) {
        for (int itr = pos; itr < data.length; itr++) {
            if (data[itr] % 2 == 0) {
                point = itr;
                return itr;
            }
        }
        return -1;
    }
}
