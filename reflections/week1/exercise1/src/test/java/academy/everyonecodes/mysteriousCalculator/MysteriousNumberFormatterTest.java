package academy.everyonecodes.mysteriousCalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MysteriousNumberFormatterTest {

    MysteriousNumberFormatter formatter = new MysteriousNumberFormatter();

    @ParameterizedTest
    @CsvSource({
            "The mysterious number is 0, 0",
            "The mysterious number is 1, 1",
            "The mysterious number is -1, -1",
    })
    void format(String expected, int number) {
        String result = formatter.format(number);

        assertEquals(expected, result);
    }
}


