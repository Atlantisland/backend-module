package academy.everyonecodes.creditCards;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IssuerTest {

    Set<String> startsWith = Set.of("5");
    Set<Integer> lengths = Set.of(1,2);
    String name = "TestIssuer";
    Issuer issuer = new Issuer(name, startsWith, lengths);

    @ParameterizedTest
    @CsvSource({
            "false, ''",
            "false, 2",
            "true, 5",
            "true, 51",
            "false, 546"
    })
    void issues(boolean expected, String input) {
        boolean result = issuer.issues(input);
        assertEquals(expected, result);
    }
}