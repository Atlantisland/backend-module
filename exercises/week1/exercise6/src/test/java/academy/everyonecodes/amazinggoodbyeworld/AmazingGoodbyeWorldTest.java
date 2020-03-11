package academy.everyonecodes.amazinggoodbyeworld;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AmazingGoodbyeWorldTest {

    @Autowired
    AmazingGoodbyeWorld amazingGoodbyeWorld;

    @Test
    void get() {
        String result = amazingGoodbyeWorld.get();

        String expected = "Goodbye World";
        assertEquals(expected, result);
    }


}