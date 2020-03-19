package academy.everyonecodes.threepwoodCinema.Beans;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TemplateEngineTest {

    @Autowired
    TemplateEngine templateEngine;

    @ParameterizedTest
    @CsvSource({
            "Good day Mr. Brown, don’t forget our 20% discount on tickets this Friday!, Mr. Brown",
            "Dear Ms. Brown, you and your friends will have so much fun at the cinema this Friday with a 20% discount!, Ms. Brown",
            "My dearest Threepwood, your lovely family gives you a 20% discount on tickets this Friday!, Threepwood",
            "Hello Brown! How about a Friday night movie? This week with a 20% discount!, Brown"
    })
    void customise(String expected, String input) {
        String result = templateEngine.customise(input);

        assertEquals(expected, result);
    }
}