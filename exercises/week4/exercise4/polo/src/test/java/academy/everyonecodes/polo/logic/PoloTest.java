package academy.everyonecodes.polo.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PoloTest {

    Polo polo = new Polo();

    @ParameterizedTest
    @CsvSource({
            "What?, ''",
            "What?, something",
            "What?, marco",
            "Polo, Marco"
    })

    void giveResponse(String expected, String input){
        String result = polo.giveResponse(input);
        Assertions.assertEquals(expected, result);
    }
}