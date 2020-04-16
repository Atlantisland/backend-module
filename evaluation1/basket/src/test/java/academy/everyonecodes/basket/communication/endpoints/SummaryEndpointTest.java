package academy.everyonecodes.basket.communication.endpoints;

import academy.everyonecodes.basket.domain.Summary;
import academy.everyonecodes.basket.logic.Basket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SummaryEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    Basket basket;

    String url = "/summaries";

    @Test
    void get() {
        restTemplate.getForObject(url, Summary[].class);

        verify(basket).getSummaries();
    }
}
