package academy.everyonecodes.calculator.beans;

import academy.everyonecodes.calculator.domain.Expression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExpressionParserTest {

    @Autowired
    ExpressionParser expressionParser;

    @Test
    void parse() {
        Expression result = expressionParser.parse("1 + 1");

        Expression expected = new Expression(1, "+", 1);
        assertEquals(expected, result);
    }
}