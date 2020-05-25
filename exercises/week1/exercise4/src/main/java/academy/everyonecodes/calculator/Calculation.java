package academy.everyonecodes.calculator;

import academy.everyonecodes.calculator.domain.Expression;

public abstract class Calculation {

    private final String symbol;

    public Calculation(String symbol) {
        this.symbol = symbol;
    }

    public boolean matches(Expression expression){
        return symbol.equals(expression.getSymbol());
    }

    public abstract double calculate(Expression expression);
}
