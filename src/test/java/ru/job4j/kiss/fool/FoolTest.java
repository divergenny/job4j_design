package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class FoolTest {
    @Test
    void checkGenerateStringWhenStartAt6ThenFizz() {
        assertThat(Fool.generateString(6), is("Fizz"));
    }

    @Test
    void checkGenerateStringWhenStartAt5ThenBuzz() {
        assertThat(Fool.generateString(5), is("Buzz"));
    }

    @Test
    void checkGenerateStringWhenStartAt15ThenFizzBuzz() {
        assertThat(Fool.generateString(15), is("FizzBuzz"));
    }

    @Test
    void checkGenerateStringWhenStartAt7Then7() {
        assertThat(Fool.generateString(7), is("7"));
    }
}
