package academy.everyonecodes.wizard.communication;

import academy.everyonecodes.wizard.logic.Wizard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WizardEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    Wizard wizard;

    String url = "/wizard";

    @Test
    void get() {
        testRestTemplate.getForObject(url, String.class);
    }
}