package academy.everyonecodes.basicyml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChoiceTest {

    @Autowired
    Choice choice;

    @Test
    void getChoice() {
        boolean result = choice.getChoice();

        boolean expected = false;
        Assertions.assertEquals(expected, result);
    }
}