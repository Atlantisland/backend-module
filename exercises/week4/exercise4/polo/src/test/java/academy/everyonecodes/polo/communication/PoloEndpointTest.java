package academy.everyonecodes.polo.communication;

import academy.everyonecodes.polo.logic.Polo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PoloEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    Polo polo;

    String url = "/polo";
    String message = "test";

    @Test
    void post(){
        restTemplate.postForObject(url + "/" + message, message, String.class);
        Mockito.verify(polo).giveResponse(message);
    }
}