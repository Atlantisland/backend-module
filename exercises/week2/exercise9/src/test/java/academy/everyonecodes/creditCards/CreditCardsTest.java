package academy.everyonecodes.creditCards;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreditCardsTest {
    @Autowired
    CreditCards creditCards;

    @ParameterizedTest
    @CsvSource({
            "Invalid, 37828224631000",
            "MasterCard, 5555555555554444",
            "American Express, 378282246310005",
            "Visa, 4111111111111111",
            "Discover, 6011111111111117"
    })
    void inspect(String expected, String input) {
        String result = creditCards.inspect(input);
        assertEquals(expected, result);
    }
}