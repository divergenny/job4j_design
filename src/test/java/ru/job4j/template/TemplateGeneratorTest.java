package ru.job4j.template;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
class TemplateGeneratorTest {
    TemplateGenerator templateGenerator = new TemplateGenerator();
    Map<String, String> mapOfArguments = new HashMap<>();
    String template = "I am a ${name}, Who are ${subject}?";

    @BeforeEach
    void init() {
        mapOfArguments.put("name", "Petr Arsentev");
        mapOfArguments.put("subject", "you");
    }

    @Test
    void whenRightParametersThenCorrectAnswers() {
        assertThat(templateGenerator.produce(template, mapOfArguments),
                Is.is("I am a Petr Arsentev, Who are you?"));
    }

    @Test
    void whenKeyInTemplateButNotInMapThenException() {
        mapOfArguments.remove("subject");
        assertThat(templateGenerator.produce(template, mapOfArguments),
                Is.is("I am a Petr Arsentev, Who are you?"));
    }

    @Test
    void whenKeyInMapButNotInTemplateThenException() {
        System.out.println(mapOfArguments);
        template = "I am a ${name}.";
        assertThat(templateGenerator.produce(template, mapOfArguments),
                Is.is("I am a Petr Arsentev, Who are you?"));
    }
}
