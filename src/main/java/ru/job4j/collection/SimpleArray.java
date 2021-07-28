package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private int capacity = 10;
    private int size = 0;
    private T[] container = (T[]) new Object[capacity];
    private int modCount = 0;


    public SimpleArray() {
        container = (T[]) new Object[capacity];
    }

    public SimpleArray(int length) {
        capacity = length;
        container = (T[]) new Object[capacity];
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    public void add(T model) {
        if (capacity == size) {
            container = grow();
        }
        container[size] = model;
        size++;
        modCount++;
    }

    private T[] grow() {
        capacity++;
        T[] copy = (T[]) new Object[capacity];
        System.arraycopy(container, 0,
                copy, 0, size);
        return copy;
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
        return capacity == that.capacity && size == that.size && modCount == that.modCount && Arrays.equals(container, that.container);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(capacity, size, modCount);
        result = 31 * result + Arrays.hashCode(container);
        return result;
    }

    @Override
    public String toString() {
        return "SimpleArray{"
                + "capacity=" + capacity
                + ", size=" + size
                + ", container=" + Arrays.toString(container)
                + ", modCount=" + modCount
                + '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int point = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[point];
            }
        };
    }
}
