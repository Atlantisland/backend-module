package academy.everyonecodes.calculator;

import java.util.Objects;

public class Expression {
    private double term1;
    private String symbol;
    private double term2;

    public Expression(double term1, String symbol, double term2) {
        this.term1 = term1;
        this.symbol = symbol;
        this.term2 = term2;
    }

    public double getTerm1() {
        return term1;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getTerm2() {
        return term2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return Double.compare(that.term1, term1) == 0 &&
                Double.compare(that.term2, term2) == 0 &&
                Objects.equals(symbol, that.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(term1, symbol, term2);
    }
}
