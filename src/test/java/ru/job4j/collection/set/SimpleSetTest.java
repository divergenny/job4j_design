package ru.job4j.collection.set;

import org.hamcrest.core.Is;
import org.junit.Test;
import java.util.Iterator;
import static org.junit.Assert.*;

public class SimpleSetTest {
    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenIterate() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        Iterator<Integer> it = set.iterator();
        assertThat(it.next(), Is.is(1));
        assertThat(it.next(), Is.is(2));
        assertThat(it.next(), Is.is(3));
        assertThat(it.next(), Is.is(4));
        assertFalse(it.hasNext());
    }
}
