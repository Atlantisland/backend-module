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
            "-0, -0.9",
            "-0, -0.5",
            "-0, -0.1",
            "1, 0.1",
            "1, 0.1",
            "1, 0.5",
            "1, 0.9"
    })
    void roundUp(double expected, double input) {
        double result = rounder.roundUp(input);

        assertEquals(expected, result);
    }


    @ParameterizedTest
    @CsvSource({
            "-1, -0.9",
            "-1, -0.5",
            "-1, -0.1",
            "0, 0.0",
            "0, 0.1",
            "0, 0.5",
            "0, 0.9"
    })
    void roundDown(double expected, double input) {
        double result = rounder.roundDown(input);

        assertEquals(expected, result);
    }

}