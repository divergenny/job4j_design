package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;
    private int modCount = 0;

    public SimpleLinkedList() {
        lastNode = new Node<E>(null, firstNode, null);
        firstNode = new Node<E>(null, null, lastNode);
    }

    public int getSize() {
        return size;
    }

    @Override
    public void add(E value) {
        Node<E> prev = lastNode;
        prev.setCurrentElement(value);
        lastNode = new Node<>(null, prev, null);
        prev.setNextElement(lastNode);
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> target = firstNode.getNextElement();
        for (int i = 0; i < index; i++) {
                target = getNextElement(target);
        }
        return target.getCurrentElement();
    }

    private Node<E> getNextElement(Node<E> current) {
        return current.getNextElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> actual = firstNode;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return actual.getNextElement() != lastNode;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E next = actual.getNextElement().getCurrentElement();
                actual = actual.getNextElement();
                return next;
            }
        };
    }
}
