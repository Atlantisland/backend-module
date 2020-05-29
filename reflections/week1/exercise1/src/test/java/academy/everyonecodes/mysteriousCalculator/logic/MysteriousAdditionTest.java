package academy.everyonecodes.mysteriousCalculator.logic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MysteriousAdditionTest {

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(0, new MysteriousAddition(0), 0),
                Arguments.of(1, new MysteriousAddition(1), 0),
                Arguments.of(-1, new MysteriousAddition(-1), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void apply(int expected, MysteriousAddition addition, int number) {
        int result = addition.apply(number);

        assertEquals(expected, result);
    }
}