package academy.everyonecodes.amazinghelloworld.amazingHelloWorld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AmazingHelloWorldTest {

    @Autowired
    AmazingHelloWorld amazingHelloWorld;

    @Test
    void get() {
        String result = amazingHelloWorld.get();

        String expected = "Hello World";
        assertEquals(expected, result);
    }
}