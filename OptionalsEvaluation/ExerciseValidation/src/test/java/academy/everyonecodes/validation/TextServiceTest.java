package academy.everyonecodes.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceTest {

    TextService textService = new TextService();

    @Test
    void returnSameTextWithMoreThan3Characters(){
        String result = textService.returnSameText("hallo world!");
        String expected = "hallo world!";

        Assertions.assertEquals(expected, result);
    }

    @Test
    void returnSameTextWith3Characters(){
        String result = textService.returnSameText("one");
        String expected = "one";

        Assertions.assertEquals(expected, result);
    }

    @Test
    void returnSameTextWithLessThan3Characters(){
        String result = textService.returnSameText("1");
        String expected = "1";

        Assertions.assertEquals(expected, result);
    }

}
