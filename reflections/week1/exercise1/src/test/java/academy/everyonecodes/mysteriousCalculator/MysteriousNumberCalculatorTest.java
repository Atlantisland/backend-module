package academy.everyonecodes.mysteriousCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MysteriousNumberCalculatorTest {

    @Autowired
    MysteriousNumberCalculator calculator;

    static Stream<Arguments> parameters(){
        return Stream.of(
                Arguments.of("The mysterious number is 8", 5),
                Arguments.of("The mysterious number is 3", 0),
                Arguments.of("The mysterious number is 4", 1)
                //Arguments.of("The mysterious number is 2", -1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(String expected, int number){
        String result = calculator.calculate(number);

        Assertions.assertEquals(expected, result);
    }
}