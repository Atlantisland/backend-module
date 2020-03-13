package academy.everyonecodes.mysteriousCalculator;

import org.springframework.stereotype.Service;

@Service
public class MysteriousNumberFormatter {

    public String format(int number) {
        return "The mysterious number is " + String.valueOf(number);
    }
}
