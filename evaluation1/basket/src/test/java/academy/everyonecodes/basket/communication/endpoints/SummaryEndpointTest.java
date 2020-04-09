package academy.everyonecodes.basket.communication.endpoints;

import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.logic.Basket;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SummaryEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    Basket basket;

    String url = "/summaries";

    @Test
    void get() {
        ItemSelection item1 = new ItemSelection("userEmail1", "itemName1", 1.0);
        ItemSelection item2 = new ItemSelection("userEmail2", "itemName2", 2.0);
        List<ItemSelection> testSelections = List.of(item1, item2);

        testRestTemplate.getForObject(url, List.class);

        Mockito.verify(basket).get(testSelections);
    }
}