package academy.everyonecodes.complexFormula.communication.endpoint;

import academy.everyonecodes.complexFormula.logic.ComplexFormula;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ComplexFormulaEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    ComplexFormula complexFormula;

    @Test
    void get() {
        String url = "/complexformula";
        int number = 1;
        restTemplate.getForObject(url + "/" + number, Integer.class);
        Mockito.verify(complexFormula).apply(1);
    }
}