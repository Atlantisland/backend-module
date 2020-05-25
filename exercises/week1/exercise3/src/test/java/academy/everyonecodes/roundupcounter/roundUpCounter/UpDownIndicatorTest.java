package academy.everyonecodes.roundupcounter.roundUpCounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UpDownIndicatorTest {

    @Autowired
    UpDownIndicator upDownIndicator;

    @ParameterizedTest
    @CsvSource({
            "SAME, 0.0",
            "SAME, 0.5",
            "UP, 0.6",
            "UP, 0.9",
            "DOWN, 0.4",
            "DOWN, 0.1",
    })

    void indicate(String expected, double number) {
        String result = upDownIndicator.indicate(number);

        Assertions.assertEquals(expected, result);
    }
}