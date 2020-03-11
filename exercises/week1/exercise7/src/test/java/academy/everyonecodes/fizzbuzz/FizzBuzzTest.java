package academy.everyonecodes.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FizzBuzzTest {

    @Autowired
    FizzBuzz fizzBuzz;

    @ParameterizedTest
    @CsvSource({
            "Fizz, 3",
            "Buzz, 5",
            "FizzBuzz, 15",
            "'14', 14",
            "'0', 0"
    })
    void apply(String expected, int number) {
        String result = fizzBuzz.apply(number);

        Assertions.assertEquals(expected, result);
    }
}