package academy.everyonecodes.secretAgentHandshakes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PriceToHandshakesTranslatorTest {

    @Autowired
    PriceToHandshakesTranslator translator;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(), 0),
                Arguments.of(List.of(), 9),
                Arguments.of(List.of("text 1"), 10),
                Arguments.of(List.of("text 1"), 31),
                Arguments.of(List.of("text 1", "text 2"), 12),
                Arguments.of(List.of("text 2", "text 1"), 21),
                Arguments.of(List.of(), 100)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void test(List<String> expected, int number) {
        List<String> result = translator.translate(number);

        assertEquals(expected, result);
    }

}