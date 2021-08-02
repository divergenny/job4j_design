package ru.job4j.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (row < data.length && data[row].length == column) {
                row++;
                column = 0;
        }
        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }

    @Override
    public String toString() {
        return "MatrixIt{"
                + "data="
                + Arrays.toString(data)
                + ", row=" + row
                + ", column=" + column
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MatrixIt matrixIt = (MatrixIt) o;
        return row == matrixIt.row && column == matrixIt.column && Arrays.equals(data, matrixIt.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(row, column);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
