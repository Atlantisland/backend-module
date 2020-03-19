package academy.everyonecodes.basicProperties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageTest {

    @Autowired
    Message message;

    @Test
    void getMessage(){
        String result = message.getMessage();

        String expected = "My brain is only a receiver, in the Universe there is a core from which we obtain knowledge, strength and inspiration. -Nikola Tesla";
        Assertions.assertEquals(expected, result);
    }

}