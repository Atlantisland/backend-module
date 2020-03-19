package academy.everyonecodes.emergencyNumbers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FireEmergencyTest {

    @Autowired
    FireEmergency fireEmergency;

    @Test
    void getName() {
        String result = fireEmergency.getName();

        String expected = "Fire brigade";
        assertEquals(expected, result);
    }

    @Test
    void getNumber() {
        int result = fireEmergency.getNumber();

        int expected = 122;
        assertEquals(expected, result);
    }
}