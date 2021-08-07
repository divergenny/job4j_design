package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class ListUtilsTest {
    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 5));
        ListUtils.addAfter(input, 3, 4);
        assertThat(Arrays.asList(0, 1, 2, 3, 4, 5), Is.is(input));
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 5));
        ListUtils.addAfter(input, 7, 4);
    }

    @Test
    public void whenRemoveIfXLessThan3() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        ListUtils.removeIf(input, x -> x < 3);
        assertThat(Arrays.asList(3, 4, 5, 6), Is.is(input));
    }

    @Test
    public void whenRemoveIfXMoreThan8() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        ListUtils.removeIf(input, x -> x > 8);
        assertThat(Arrays.asList(0, 1, 2, 3, 4, 5, 6), Is.is(input));
    }

    @Test
    public void whenReplaceIfXEqual4() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        ListUtils.replaceIf(input, num -> num == 4, 97);
        assertThat(Arrays.asList(0, 1, 2, 3, 97, 5, 6), Is.is(input));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        ListUtils.removeAll(input, new ArrayList<>(Arrays.asList(1, 2, 3)));
        assertThat(Arrays.asList(0, 4, 5, 6), Is.is(input));
    }
}
