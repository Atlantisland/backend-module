package academy.everyonecodes.calculator.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

class CalculatorTest {

    @Autowired
    Calculator calculator;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, "1 * 1"),
                Arguments.of(2.0, "1.0 + 1.0"),
                Arguments.of(4.0, "5.0 - 1.0"),
                Arguments.of(2.0, "10.0 / 5.0"),
                Arguments.of(-1, "-1 * 1"),
                Arguments.of(2, "-3 + 5"),
                Arguments.of(-6.0, "-5.0 - 1.0"),
                Arguments.of(-2.0, "-10.0 / 5.0")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(double expected, String input) {
        double result = calculator.calculate(input);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "1 & 1"
    })
    void calculate(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.calculate(input));
    }
}