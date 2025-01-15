package ru.job4j.algo.sort;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeTest {
    @Test
    void whenNotSortedThenOk() {
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        assertThat(Merge.mergesort(array)).containsExactly(-13, 2, 3, 4, 4, 6, 8, 10);
    }

    @Test
    void whenSortedArrayThenOk() {
        int[] array = {1, 2, 3, 4, 5};
        assertThat(Merge.mergesort(array)).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void whenReversedArrayThenOk() {
        int[] array = {5, 4, 3, 2, 1};
        assertThat(Merge.mergesort(array)).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void whenArrayWithDuplicatesThenOk() {
        int[] array = {7, 7, 3, 3, 1, 1};
        assertThat(Merge.mergesort(array)).containsExactly(1, 1, 3, 3, 7, 7);
    }

    @Test
    void whenArrayWithNegativeNumbersThenOk() {
        int[] array = {-5, -1, -3, 0, 2, 1};
        assertThat(Merge.mergesort(array)).containsExactly(-5, -3, -1, 0, 1, 2);
    }

    @Test
    void whenEmptyArrayThenOk() {
        int[] array = {};
        assertThat(Merge.mergesort(array)).isEmpty();
    }

    @Test
    void whenSingleElementArrayThenOk() {
        int[] array = {42};
        assertThat(Merge.mergesort(array)).containsExactly(42);
    }

    @Test
    void whenLargeArrayThenOk() {
        int[] array = {100, -100, 50, -50, 0, 25, -25};
        assertThat(Merge.mergesort(array)).containsExactly(-100, -50, -25, 0, 25, 50, 100);
    }
}
