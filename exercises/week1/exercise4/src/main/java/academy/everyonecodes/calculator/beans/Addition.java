package academy.everyonecodes.calculator.beans;

import academy.everyonecodes.calculator.Calculation;
import academy.everyonecodes.calculator.domain.Expression;
import org.springframework.stereotype.Service;

@Service
public class Addition extends Calculation {

    public Addition() {
        super("+");
    }

    @Override
    public double calculate(Expression expression) {

        return expression.getTerm1() + expression.getTerm2();
    }
}
