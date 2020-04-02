package academy.everyonecodes.marco.communication;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PoloClientTest {

    @Autowired
    PoloClient poloClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${message.server.url}")
    String url;

    @Test
    void getMessage() {
        String message = "Marco";
        Mockito.when(restTemplate.postForObject(url + "/" + message, message, String.class))
                .thenReturn("Polo");
        poloClient.post(message);
        Mockito.verify(restTemplate).postForObject(url + "/" + message, message, String.class);
    }
}

