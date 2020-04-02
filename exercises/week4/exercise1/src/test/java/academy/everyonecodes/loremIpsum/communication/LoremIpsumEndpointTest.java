package academy.everyonecodes.loremIpsum.communication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoremIpsumEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    RestTemplate restTemplate;

    String url = "/loremipsum";

    @Test
    void get(){
        String apiUrl = "https://loripsum.net/api";
        String expected = "test";
        Mockito.when(restTemplate.getForObject(apiUrl, String.class)).thenReturn(expected);

        String response = testRestTemplate.getForObject(url, String.class);

        Assertions.assertEquals(expected, response);
        Mockito.verify(restTemplate).getForObject(apiUrl, String.class);
    }

}