package academy.everyonecodes.mysteriousCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MysteriousNumberFormatterTest {

    @Autowired
    MysteriousNumberFormatter formatter;

    @Test
    void formatWith0() {
        String result = formatter.format(0);

        String expected = "The mysterious number is 0";
        Assertions.assertEquals(expected, result);

    }

@Test
    void formatWith5() {
        String result = formatter.format(5);

        String expected = "The mysterious number is 5";
        Assertions.assertEquals(expected, result);

    }

}