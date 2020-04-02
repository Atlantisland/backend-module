package academy.everyonecodes.home.communication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomeEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;
    @Value("home")
    String nameHome;

    @Test
    void get() {
        String url = "/home";
        String result = restTemplate.getForObject(url, String.class);
        assertEquals(nameHome, result);
    }
}