package academy.everyonecodes.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MultipleFinderTest {

    MultipleFinder multipleFinderOfThree = new MultipleFinder(3);
    MultipleFinder multipleFinderOfFive = new MultipleFinder(5);


    @ParameterizedTest
    @CsvSource({
            "false, 0",
            "false, 1",
            "false, -1",
            "false, 16",
            "false, -16",
            "true, 3",

    })
    void isMultiplyForThree(boolean expected, int number) {
        boolean result = multipleFinderOfThree.isMultiple(number);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "false, 0",
            "false, 1",
            "false, -1",
            "false, 16",
            "false, -16",
            "true, 5",

    })
    void isMultiplyForFive(boolean expected, int number) {
        boolean result = multipleFinderOfFive.isMultiple(number);

        Assertions.assertEquals(expected, result);
    }
}