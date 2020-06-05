package academy.everyonecodes.dorothy.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class HomeClientTest {

    @Autowired
    HomeClient homeClient;

    @MockBean
    RestTemplate restTemplate;

    @Test
    void getHomeMessage(){
        String homeUrl = "homeUrl";

        homeClient.getHomeMessage(homeUrl);

        verify(restTemplate).getForObject(homeUrl, String.class);
    }
}

