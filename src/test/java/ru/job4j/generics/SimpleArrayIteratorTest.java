package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayIteratorTest {
    private SimpleArray<String> sa;
    Iterator itr;

    @Before
    public void setUp() {
        sa = new SimpleArray<>(6);
        sa.add("Vlad");
        sa.add("August");
        sa.add("Hot");
        sa.add("Help Me");
        sa.add("I am learning");
        sa.add("Programming on Java");
        itr = sa.iterator();
    }

    @Test
    public void hasNext() {
        assertTrue(itr.hasNext());
        itr.next();
        assertTrue(itr.hasNext());
        itr.next();
        assertTrue(itr.hasNext());
        itr.next();
        assertTrue(itr.hasNext());
        itr.next();
        assertTrue(itr.hasNext());
        itr.next();
        assertTrue(itr.hasNext());
        itr.next();
        assertFalse(itr.hasNext());
    }

    @Test
    public void next() {
        assertThat(itr.next(), is("Vlad"));
        assertThat(itr.next(), is("August"));
    }
}