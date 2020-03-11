package academy.everyonecodes.amazinggoodbyeworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WorldTest {

    @Autowired
    World world;


    @Test
    void get() {
        String result = world.get();

        String expected = "World";
        assertEquals(expected, result);
    }
}