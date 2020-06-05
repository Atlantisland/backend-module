package academy.everyonecodes.mocky.communication;

import academy.everyonecodes.mocky.domain.Postcard;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MockyPostcardsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    RestTemplate restTemplate;

    @Value("${mocky.url.postcards.one}")
    String oneUrl;

    @Value("${mocky.url.postcards.two}")
    List<String> twoUrls;

    String url = "/mocky/postcards";

    Postcard expectedPostcard1 = new Postcard("Silvia", "Anne", "My trip s awesome so far! I'm looking forward to tell you all about it");
    Postcard expectedPostcard2 = new Postcard("Tom", "Ryan", "You have to visit this place, mate! It's great!");

    @Test
    void getOne() {
        Mockito.when(restTemplate.getForObject(oneUrl, Postcard.class))
                .thenReturn(expectedPostcard1);

        Postcard result = testRestTemplate.getForObject(url + "/1", Postcard.class);

        assertEquals(expectedPostcard1, result);
        Mockito.verify(restTemplate).getForObject(oneUrl, Postcard.class);
    }

    @Test
    void getTwo() {
        Mockito.when(restTemplate.getForObject(twoUrls.get(0), Postcard.class))
                .thenReturn(expectedPostcard1);
        Mockito.when(restTemplate.getForObject(twoUrls.get(1), Postcard.class))
                .thenReturn(expectedPostcard2);

        Postcard[] response = testRestTemplate.getForObject(url + "/2", Postcard[].class);
        List<Postcard> result = List.of(response);

        List<Postcard> expected = List.of(expectedPostcard1, expectedPostcard2);
        assertEquals(expected, result);
        Mockito.verify(restTemplate).getForObject(twoUrls.get(0), Postcard.class);
        Mockito.verify(restTemplate).getForObject(twoUrls.get(1), Postcard.class);
    }
}