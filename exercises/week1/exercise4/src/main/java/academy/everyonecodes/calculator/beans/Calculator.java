package academy.everyonecodes.calculator.beans;


import academy.everyonecodes.calculator.Calculation;
import academy.everyonecodes.calculator.domain.Expression;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class Calculator {
    private final ExpressionParser expressionParser;
    private final Set<Calculation> calculations;

    public Calculator(ExpressionParser expressionParser, Set<Calculation> calculations) {
        this.expressionParser = expressionParser;
        this.calculations = calculations;
    }

    public double calculate(String text) {
        Expression expression = expressionParser.parse(text);
        return calculations.stream()
                .filter(calculator -> calculator.matches(expression))
                .map(calculator -> calculator.calculate(expression))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

