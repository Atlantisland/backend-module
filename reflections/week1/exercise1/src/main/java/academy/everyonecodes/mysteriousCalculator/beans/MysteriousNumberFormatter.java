package academy.everyonecodes.mysteriousCalculator.beans;

import org.springframework.stereotype.Service;

@Service
public class MysteriousNumberFormatter {

    public String format(int number){
        return "The mysterious number is " + number;
    }
}
