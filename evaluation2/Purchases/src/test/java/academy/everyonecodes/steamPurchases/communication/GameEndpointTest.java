package academy.everyonecodes.steamPurchases.communication;

import academy.everyonecodes.steamPurchases.logic.PurchaseService;
import academy.everyonecodes.steamPurchases.persistence.domain.Game;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GameEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    PurchaseService purchaseService;

    String url = "/games";

    @Test
    void get(){
        testRestTemplate.getForObject(url, Game[].class);

        verify(purchaseService).findAll();
    }
}