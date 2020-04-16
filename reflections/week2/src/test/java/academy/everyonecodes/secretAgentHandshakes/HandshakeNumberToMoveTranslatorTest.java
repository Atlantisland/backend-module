package academy.everyonecodes.secretAgentHandshakes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HandshakeNumberToMoveTranslatorTest {

    @Autowired
    HandshakeNumberToMoveTranslator translator;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(Optional.empty(), 0),
                Arguments.of(Optional.of("text 1"), 1),
                Arguments.of(Optional.of("text 2"), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void translate(Optional<String> expected, int number) {
        Optional<String> result = translator.translate(number);

        assertEquals(expected, result);
    }
}
