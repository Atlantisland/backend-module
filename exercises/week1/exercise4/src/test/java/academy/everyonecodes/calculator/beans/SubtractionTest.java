package academy.everyonecodes.calculator.beans;

import academy.everyonecodes.calculator.Calculation;
import academy.everyonecodes.calculator.domain.Expression;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubtractionTest {

    @Autowired
    Calculation subtraction;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(0.0, new Expression(0, "-", 0)),
                Arguments.of(1.0, new Expression(1, "-",  0)),
                Arguments.of(-1.0, new Expression(0, "-", 1)),
                Arguments.of(2.0, new Expression(1, "-", -1)),
                Arguments.of(-2.0, new Expression(-1, "-", 1)),
                Arguments.of(0.0, new Expression(-1, "-", -1))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(Double expected, Expression expression) {
        double result = subtraction.calculate(expression);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "true, -",
            "false, $",
    })
    void matches(boolean expected, String symbol) {
        Expression expression = new Expression(0, symbol, 0);

        boolean result = subtraction.matches(expression);

        assertEquals(expected, result);
    }
}
