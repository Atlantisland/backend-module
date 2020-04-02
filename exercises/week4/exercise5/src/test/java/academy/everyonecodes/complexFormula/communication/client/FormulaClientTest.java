package academy.everyonecodes.complexFormula.communication.client;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class FormulaClientTest {

    @Autowired
    FormulaClient formulaClient;

    @MockBean
    RestTemplate restTemplate;
    @Value("${formula.url}")
    String url;

    @Test
    void post() {
        formulaClient.post(1);
        Mockito.verify(restTemplate).postForObject(url, 1, Integer.class);
    }
}