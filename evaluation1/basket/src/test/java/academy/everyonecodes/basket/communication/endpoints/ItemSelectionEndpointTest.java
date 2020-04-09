package academy.everyonecodes.basket.communication.endpoints;

import academy.everyonecodes.basket.domain.ItemSelection;
import academy.everyonecodes.basket.logic.SummaryCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemSelectionEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    SummaryCalculator calculator;

    String url = "/itemselections";

    @Test
    void post(){
        ItemSelection selection = new ItemSelection("userEmail", "itemName", 3.2);

        testRestTemplate.postForObject(url, selection, ItemSelection.class);

        verify(calculator).calculateSummary(selection);
    }

}