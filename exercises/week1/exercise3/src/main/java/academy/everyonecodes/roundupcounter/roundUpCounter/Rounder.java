package academy.everyonecodes.roundupcounter.roundUpCounter;

import org.springframework.stereotype.Service;

@Service
public class Rounder {

    public double roundUp(double number) {
        return Math.ceil(number);
    }

    public double roundDown(double number) {
        return Math.floor(number);
    }
}
