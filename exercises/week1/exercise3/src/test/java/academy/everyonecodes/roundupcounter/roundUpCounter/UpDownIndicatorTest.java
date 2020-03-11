package academy.everyonecodes.roundupcounter.roundUpCounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UpDownIndicatorTest {

    @Autowired
    UpDownIndicator upDownIndicator;

    @ParameterizedTest
    @CsvSource({
            "UP, 3.6",
            "DOWN, 3.3",
            "SAME, 3.0",
            "UP, 3.5",
            "UP, -3.5"
    })

    void indicate(String expected, double number) {
        String result = upDownIndicator.indicate(number);

        Assertions.assertEquals(expected, result);
    }
}