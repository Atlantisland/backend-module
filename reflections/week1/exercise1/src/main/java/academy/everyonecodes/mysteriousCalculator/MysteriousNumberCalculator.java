package academy.everyonecodes.mysteriousCalculator;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MysteriousNumberCalculator {

    private final MysteriousNumberFormatter mysteriousNumberFormatter;
    private final Set<MysteriousAddition> mysteriousAdditions;

    public MysteriousNumberCalculator(MysteriousNumberFormatter mysteriousNumberFormatter, Set<MysteriousAddition> mysteriousAdditions) {
        this.mysteriousNumberFormatter = mysteriousNumberFormatter;
        this.mysteriousAdditions = mysteriousAdditions;
    }


    public String calculate(int number) {
        int result = mysteriousAdditions.stream()
                .map(mysteriousAddition -> mysteriousAddition.apply(number))
                .reduce(0, (numberOne, numberTwo) -> numberOne + numberTwo) - number;
        return mysteriousNumberFormatter.format(result);
    }
}
