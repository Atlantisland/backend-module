package academy.everyonecodes.calculator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;


@SpringBootTest
class ExpressionParserTest {

    @Autowired
    ExpressionParser expressionParser;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new Expression(1, "*", 1), "1 * 1"),
                Arguments.of(new Expression(1, "/", 1), "1 / 1"),
                Arguments.of(new Expression(1, "+", 1), "1 + 1")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void parse(Expression expected, String input) {
        Expression result = expressionParser.parse(input);

        Assertions.assertEquals(expected, result);
    }
}