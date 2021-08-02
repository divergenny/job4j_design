package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    SimpleArray<Integer> integers;

    @Before
    public void setUp() {
        integers = new SimpleArray<>(5);
        integers.add(1);
        integers.add(2);
        integers.add(3);
    }

    @Test
    public void add() {
        integers.add(23);
        int expected = 23;
        int result =  integers.get(3);
        assertEquals(expected, result);
    }

    @Test
    public void set() {
        integers.set(0, 10);
        int expected = 10;
        int result =  integers.get(0);
        assertEquals(expected, result);
    }

    @Test
    public void remove() {
        integers.remove(1);
        SimpleArray<Integer> expected = new SimpleArray<>(5);
        expected.add(1);
        expected.add(3);
        assertEquals(expected, integers);
    }

    @Test
    public void whenAddAndRemoveAllElements() {
        SimpleArray<Integer> list = new SimpleArray<>(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        list.remove(1);
        list.remove(0);
        SimpleArray<Integer> expected = new SimpleArray<>(3);
        assertEquals(expected, list);
    }
}
