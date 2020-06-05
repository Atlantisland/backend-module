package academy.everyonecodes.home.logic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class HomeTest {

    @Autowired
    Home home;

    @Value("${home.message}")
    String message;

    @Test
    void getMessage(){
        String result = home.getMessage();

        assertEquals(message, result);
    }
}