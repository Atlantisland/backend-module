package academy.everyonecodes.secretAgentHandshakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HandshakeNumberToMoveTranslatorTest {

    @Autowired
    HandshakeNumberToMoveTranslator translator;

    @ParameterizedTest
    @CsvSource({
            "thumb, 2",
            "little, 3",
            "tickles, 5",
            "bro, 6",
            "thousand, 9"
    })

    void translate(Optional<String> expected, int input) {
        Optional<String> result = translator.translate(input);

        Assertions.assertEquals(expected, result);
    }

   @Test
    void testNoMove() {
       Optional<String> oResult = translator.translate(0);
        assertTrue(oResult.isEmpty());
    }
}