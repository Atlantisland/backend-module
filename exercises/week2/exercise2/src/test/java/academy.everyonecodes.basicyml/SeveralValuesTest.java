package academy.everyonecodes.basicyml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SeveralValuesTest {

    @Autowired
    SeveralValues severalValues;

    @Test
    void getSeveralNaturalNumbers() {
        List<Integer> result = severalValues.getSeveralNaturalNumbers();

        List<Integer> expected = List.of(3, 6, 9);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getSeveralDecimalNumbers() {
        List<Double> result = severalValues.getSeveralDecimalNumbers();

        List<Double> expected = List.of(3.14, 2.71, 3.359);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getSeveralWords() {
        List<String> result = severalValues.getSeveralWords();

        List<String> expected = List.of("Answer", "to", "the", "Ultimate", "Question", "of", "Life", "the", "Universe", "and", "Everything");
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getSeveralChoices() {
        List<Boolean> result = severalValues.getSeveralChoices();

        List<Boolean> expected = List.of(true, false, false, true);
        Assertions.assertEquals(expected, result);
    }
}