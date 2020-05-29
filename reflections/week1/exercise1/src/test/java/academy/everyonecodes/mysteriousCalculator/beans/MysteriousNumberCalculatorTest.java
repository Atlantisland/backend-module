package academy.everyonecodes.mysteriousCalculator.beans;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MysteriousNumberCalculatorTest {

    @Autowired
    MysteriousNumberCalculator calculator;

    @ParameterizedTest
    @CsvSource({
            "The mysterious number is 3, 0",
            "The mysterious number is 4, 1",
            "The mysterious number is 2, -1"
    })

    void colacualte(String expected, int number){
        String result = calculator.calculate(number);

        assertEquals(expected, result);
    }

}