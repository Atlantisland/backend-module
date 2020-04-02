package academy.everyonecodes.wizard.communication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WizardEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @Value("${home.url}")
    String homeUrl;

    @Test
    void get() {
        String url = "/wizard";
        String result = restTemplate.getForObject(url, String.class);
        assertEquals(homeUrl, result);
    }
}