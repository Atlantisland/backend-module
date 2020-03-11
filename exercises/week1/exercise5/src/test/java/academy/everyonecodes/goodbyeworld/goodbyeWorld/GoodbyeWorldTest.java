package academy.everyonecodes.goodbyeworld.goodbyeWorld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodbyeWorldTest {

    @Autowired
    GoodbyeWorld goodbyeWorld;


    @Test
    void get() {
        String result = goodbyeWorld.get();

        String expected = "Goodbye World";
        assertEquals(expected, result);
    }
}