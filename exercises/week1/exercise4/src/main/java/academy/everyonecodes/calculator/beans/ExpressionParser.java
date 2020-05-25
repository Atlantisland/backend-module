package academy.everyonecodes.calculator.beans;

import academy.everyonecodes.calculator.domain.Expression;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpressionParser {

    public Expression parse(String text) throws ArrayIndexOutOfBoundsException {
        List<String> input = List.of(text.split(" "));
        Expression expression = new Expression(Double.parseDouble(input.get(0)), input.get(1), Double.parseDouble(input.get(2)));
        return expression;
    }
}
