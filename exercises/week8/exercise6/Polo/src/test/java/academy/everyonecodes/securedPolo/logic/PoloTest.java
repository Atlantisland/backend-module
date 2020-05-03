package academy.everyonecodes.securedPolo.logic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PoloTest {
    @Autowired
    Polo poloService;

    static Stream<Arguments> parameters() {
        return Stream.of(
                of("What?", ""),
                of("What?", "marco"),
                of("Polo", "Marco")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void respond(String expected, String message) {
        String result = poloService.respond(message);

        assertEquals(expected, result);
    }
}