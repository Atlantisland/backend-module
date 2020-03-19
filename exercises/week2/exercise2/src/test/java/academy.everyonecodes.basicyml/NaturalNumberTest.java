package academy.everyonecodes.basicyml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NaturalNumberTest {

    @Autowired
    NaturalNumber naturalNumber;

    @Test
    void getNaturalNumber(){
        int result = naturalNumber.getNaturalNumber();

        int expected = 369;
        Assertions.assertEquals(expected, result);
    }
}