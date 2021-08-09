package ru.job4j.collection.map;

import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.nullValue;

public class SimpleMapTest {
    @Test
    public void whenPutSameElementTwice() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put(1, 1));
        assertFalse(simpleMap.put(1, 1));
    }

    @Test
    public void whenPutDifferentElements() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put(1, 1));
        assertTrue(simpleMap.put(2, 2));
        assertTrue(simpleMap.put(3, 3));
    }

    @Test
    public void whenExpand() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        simpleMap.put(1, 100);
        simpleMap.put(2, 200);
        simpleMap.put(3, 300);
        simpleMap.put(4, 400);
        simpleMap.put(5, 500);
        simpleMap.put(6, 600);
        simpleMap.put(7, 700);
        simpleMap.put(8, 800);
        simpleMap.put(9, 900);
        assertThat(simpleMap.get(1), is(100));
        assertThat(simpleMap.get(9), is(900));
    }

    @Test
    public void whenGetElementByKey() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        simpleMap.put(1, 100);
        simpleMap.put(2, 200);
        assertThat(simpleMap.get(1), is(100));
    }

    @Test
    public void whenPutAndRemoveAndPutValue() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        simpleMap.put(1, 100);
        simpleMap.put(2, 200);
        simpleMap.remove(1);
        assertThat(simpleMap.get(1), is(nullValue()));
        simpleMap.put(1, 500);
        assertThat(simpleMap.get(1), is(500));
    }

    @Test
    public void whenPutAndRemoveValueAndGetDeletedElement() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put(1, 100));
        assertTrue(simpleMap.put(2, 200));
        assertTrue(simpleMap.remove(1));
        assertThat(simpleMap.get(1), is(nullValue()));
    }

    @Test
    public void whenIterate() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        simpleMap.put(1, 100);
        simpleMap.put(2, 200);
        simpleMap.put(3, 300);
        simpleMap.put(4, 400);
        simpleMap.put(5, 500);
        Iterator<Integer> itr = simpleMap.iterator();
        assertTrue(itr.hasNext());
        assertThat(itr.next(), is(1));
        assertTrue(itr.hasNext());
        assertThat(itr.next(), is(2));
        assertTrue(itr.hasNext());
        assertThat(itr.next(), is(3));
        assertTrue(itr.hasNext());
        assertThat(itr.next(), is(4));
        assertTrue(itr.hasNext());
        assertThat(itr.next(), is(5));
        assertFalse(itr.hasNext());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorException() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        simpleMap.put(1, 100);
        simpleMap.put(2, 200);
        Iterator<Integer> iterator = simpleMap.iterator();
        simpleMap.put(3, 300);
        iterator.hasNext();
    }
}
