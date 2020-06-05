package academy.everyonecodes.marco.communication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MarcoEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    PoloClient poloClient;

    String url = "/marco";

    @Test
    void getMessage() {
        String message = "marco";
        String expected = "answer";
        when(poloClient.post(message))
                .thenReturn(expected);

        String response = restTemplate.getForObject(url + "/" + message, String.class);

        assertEquals(expected, response);
        Mockito.verify(poloClient).post(message);
    }
}