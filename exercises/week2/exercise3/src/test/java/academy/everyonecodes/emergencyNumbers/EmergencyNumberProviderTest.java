package academy.everyonecodes.emergencyNumbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmergencyNumberProviderTest {

    @Autowired
    EmergencyNumberProvider emergencyNumberProvider;

    @ParameterizedTest
    @CsvSource({
            "112, ' '",
            "122, Fire brigade",
            "133, Police",
            "112, General emergency"
    })
    void provide(int expected, String input) {
        int result = emergencyNumberProvider.provide(input);

        assertEquals(expected, result);
    }
}