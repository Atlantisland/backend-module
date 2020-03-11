package academy.everyonecodes.calculator.calculations;

import academy.everyonecodes.calculator.Expression;

public abstract class Calculation {

    private final String symbol;

    public Calculation(String symbol) {
        this.symbol = symbol;
    }

    public boolean matches(Expression expression) {
        return symbol.equals(expression.getSymbol());
    }

    public abstract double calculate(Expression expression);

}
