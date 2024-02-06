package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class FoolTest {
    Fool gameFool = new Fool();

    @Test
    void checkModBy3Or5WhenStartAt6() {
        assertThat(gameFool.checkModBy3Or5(6), is("Fizz"));
    }

    @Test
    void checkModBy3Or5WhenStartAt5() {
        assertThat(gameFool.checkModBy3Or5(5), is("Buzz"));
    }

    @Test
    void checkModBy3Or5WhenStartAt15() {
        assertThat(gameFool.checkModBy3Or5(15), is("FizzBuzz"));
    }

    @Test
    void checkModBy3Or5WhenStartAt7() {
        assertThat(gameFool.checkModBy3Or5(7), is("7"));
    }

    @Test
    void checkThatAnswerIsIncorrectWhenCorrect() {
        gameFool.setStartAt(6);
        assertThat(gameFool.checkThatAnswerIsIncorrect("Fizz"), is(false));
    }

    @Test
    void checkThatAnswerIsIncorrectWhenIncorrect() {
        gameFool.setStartAt(6);
        assertThat(gameFool.checkThatAnswerIsIncorrect("Buzz"), is(true));
    }
}
