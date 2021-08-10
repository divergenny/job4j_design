package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    /**
     * Метод add - находит узел по
     * значению parent и добавляет в него дочерний узел
     * со значением child.
     * В этом методе нужно проверить, что значение
     * child еще нет в дереве а parent есть.
     * Если child есть, то метод должен вернуть false.
     * @param parent Element
     * @param child Element
     * @return true in case child add.
     */
    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> childFound = findBy(child);
        Optional<Node<E>> parentFound = findBy(parent);
        if (childFound.isPresent() || !parentFound.isPresent()) {
            return false;
        }
        Node<E> newChild = new Node<>(child);
        parentFound.get().children.add(newChild);
        return true;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(el -> el.value.equals(value));
    }

    @Override
    public boolean isBinary() {
        Optional<Node<E>> rsl = findByPredicate(element -> element.children.size() > 2);
        return rsl.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleTree<?> that = (SimpleTree<?>) o;
        return Objects.equals(root, that.root);
    }

    @Override
    public int hashCode() {
        return Objects.hash(root);
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
