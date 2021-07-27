package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private T[] array;
    private int size = 0;


    public SimpleArray(int length) {
        this.array = (T[]) new Object[length];

    }

    public void add(T model) {
        array[size] = model;
        size++;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        array[index] = model;
    }

    public void remove(int removedIndex) {
        Objects.checkIndex(removedIndex, size);
        System.arraycopy(array, removedIndex + 1,
                array, removedIndex, array.length - 1 - removedIndex);
        size--;
    }

    public T get(int index) {
        return array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator<>(array);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleArray<?> that = (SimpleArray<?>) o;
        return size == that.size && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        return "SimpleArray{"
                + "array=" + Arrays.toString(array)
                + ", size=" + size
                + '}';
    }
}
