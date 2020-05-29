package academy.everyonecodes.mysteriousCalculator.beans;

import academy.everyonecodes.mysteriousCalculator.logic.MysteriousAddition;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MysteriousNumberCalculator {

    private final Set<MysteriousAddition> mysteriousAdditions;
    private final MysteriousNumberFormatter formatter;

    public MysteriousNumberCalculator(Set<MysteriousAddition> mysteriousAdditions, MysteriousNumberFormatter formatter) {
        this.mysteriousAdditions = mysteriousAdditions;
        this.formatter = formatter;
    }

    public String calculate(int number) {
        for (MysteriousAddition mysteriousAddition : mysteriousAdditions) {
            number = mysteriousAddition.apply(number);
        }
        return formatter.format(number);
    }
}
