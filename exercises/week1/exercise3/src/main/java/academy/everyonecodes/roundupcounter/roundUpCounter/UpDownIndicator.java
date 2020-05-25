package academy.everyonecodes.roundupcounter.roundUpCounter;

import org.springframework.stereotype.Service;

@Service
public class UpDownIndicator {

    private final Rounder rounder;

    public UpDownIndicator(Rounder rounder) {
        this.rounder = rounder;
    }

    public String indicate(double number) {
        double ceilDistance = calculateDistanceToCeil(number);
        double floorDistance = calculateDistanceToFloor(number);
        if (ceilDistance < floorDistance) {
            return "UP";
        }
        if (ceilDistance > floorDistance) {
            return "DOWN";
        }
        return "SAME";
    }

    private double calculateDistanceToCeil(double number) {
        double ceil = rounder.roundUp(number);
        return ceil - number;
    }

    private double calculateDistanceToFloor(double number) {
        double floor = rounder.roundDown(number);
        return number - floor;
    }
}
