package academy.everyonecodes.roundupcounter.roundUpCounter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RounderTest {

    @Autowired
    Rounder rounder;

    @ParameterizedTest
    @CsvSource({
            "4.0, 3.2",
            "-3.0, -3.2",
            "1.0, 0.55"
    })
    void roundUp(double expected, double input) {
        double result = rounder.roundUp(input);

        assertEquals(expected, result);
    }


    @ParameterizedTest
    @CsvSource({
            "3.0, 3.2",
            "-4.0, -3.5",
            "0.0, 0.35"
    })
    void roundDown(double expected, double input) {
        double result = rounder.roundDown(input);

        assertEquals(expected, result);
    }

}