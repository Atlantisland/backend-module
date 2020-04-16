package academy.everyonecodes.roundupcounter.roundUpCounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
class UpCounterTest {

    @Autowired
    UpCounter upCounter;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(3, List.of(3.5, 4.9, 2.0, 2.8)),
                Arguments.of(1, List.of(3.0, 4.3, -2.0, -2.3)),
                Arguments.of(0, List.of(3.0, 4.3, -2.0, -2.8)),
                Arguments.of(0, List.of()),
                Arguments.of(0, List.of(0.0)),
                Arguments.of(1, List.of(0.6))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void count(long expected, List<Double> numbers) {
        long result = upCounter.count(numbers);

        Assertions.assertEquals(expected, result);

    }
}