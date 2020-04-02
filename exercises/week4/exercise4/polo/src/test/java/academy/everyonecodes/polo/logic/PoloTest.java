package academy.everyonecodes.polo.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PoloTest {

    Polo polo = new Polo();

    @ParameterizedTest
    @CsvSource({
            "Polo, Marco",
            "What?, marco"
    })

    void giveResponse(String expected, String input){
        String result = polo.giveResponse(input);
        Assertions.assertEquals(expected, result);
    }
}