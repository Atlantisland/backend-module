package academy.everyonecodes.roundupcounter.roundUpCounter;

import org.springframework.stereotype.Service;

@Service
public class UpDownIndicator {
    private final Rounder rounder;


    public UpDownIndicator(Rounder rounder) {
        this.rounder = rounder;
    }

    public String indicate(double number) {
        double difference = rounder.roundUp(number) - number;
        //double roundedDownSubNumber = rounder.roundDown(number) - number;

        if (difference > 0.5) {
            return "DOWN";
        }
        if (difference == 0) {
            return "SAME";
        }
        return "UP";

    }
}
