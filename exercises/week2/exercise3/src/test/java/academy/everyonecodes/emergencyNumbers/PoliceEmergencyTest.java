package academy.everyonecodes.emergencyNumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PoliceEmergencyTest {

    @Autowired
    PoliceEmergency policeEmergency;

    @Test
    void getName() {
        String result = policeEmergency.getName();

        String expected = "Police";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getNumber() {
        int result = policeEmergency.getNumber();

        int expected = 133;
        assertEquals(expected, result);
    }
}