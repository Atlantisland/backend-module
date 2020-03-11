package academy.everyonecodes.calculator.calculations;


import academy.everyonecodes.calculator.Expression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
class MultiplicationTest {

    @Autowired
    Calculation multiplication;

    static Stream<Arguments> parameters1() {
        return Stream.of(
                Arguments.of(true, new Expression(2, "*", 1)),
                Arguments.of(false, new Expression(2, "/", 1)),
                Arguments.of(false, new Expression(2.0, "$", 1.5))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters1")
    void matches(boolean expected, Expression input) {
        boolean result = multiplication.matches(input);

        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> parameters2() {
        return Stream.of(
                Arguments.of(2, new Expression(2, "*", 1)),
                Arguments.of(-2.5, new Expression(-2.5, "*", 1)),
                Arguments.of(-2.5, new Expression(2.5, "*", -1))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters2")
    void calculate(double expected, Expression input) {
        double result = multiplication.calculate(input);

        Assertions.assertEquals(expected, result);
    }

}