package academy.everyonecodes.basket.communication.endpoints;

import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.logic.Basket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemSelectionEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    Basket basket;

    String url = "/itemselections";

    @Test
    void post() {
        ItemSelection itemSelection = new ItemSelection("test", "test", 1.0);

        restTemplate.postForObject(url, itemSelection, ItemSelection.class);

        verify(basket).process(itemSelection);
    }
}
