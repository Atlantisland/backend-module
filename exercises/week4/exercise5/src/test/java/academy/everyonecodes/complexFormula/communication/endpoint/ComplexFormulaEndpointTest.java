package academy.everyonecodes.complexFormula.communication.endpoint;

import academy.everyonecodes.complexFormula.logic.ComplexFormula;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ComplexFormulaEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    ComplexFormula complexFormula;

    String url = "/complexformula";

    @Test
    void get() {
        int number = 1234;
        int expected = 4321;
        when(complexFormula.apply(number))
                .thenReturn(expected);
        int response = restTemplate.getForObject(url + "/" + number, Integer.class);

        assertEquals(expected, response);
        Mockito.verify(complexFormula).apply(number);
    }
}