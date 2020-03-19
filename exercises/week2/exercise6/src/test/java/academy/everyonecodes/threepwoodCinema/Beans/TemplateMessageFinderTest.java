package academy.everyonecodes.threepwoodCinema.Beans;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TemplateMessageFinderTest {

    @Autowired
    TemplateMessageFinder templateMessageFinder;

    @ParameterizedTest
    @CsvSource({
            "Good day --name--!, Mr. name",
            "Dear --name--!, Ms. name",
            "My dearest --name--!, Threepwood name",
            "Hello --name--!, name"
    })
    void find(String expected, String input) {
        String result = templateMessageFinder.find(input);

        assertEquals(expected, result);
    }
}
