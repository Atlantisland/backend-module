package academy.everyonecodes.home.communication;

import academy.everyonecodes.home.logic.Home;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomeEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    Home home;

    String url = "/home";

    @Test
    void get() {
        testRestTemplate.getForObject(url, String.class);

        verify(home).getMessage();
    }
}