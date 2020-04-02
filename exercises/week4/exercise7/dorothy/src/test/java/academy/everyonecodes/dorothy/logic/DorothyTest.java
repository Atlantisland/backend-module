package academy.everyonecodes.dorothy.logic;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DorothyTest {
    @Autowired
    Dorothy dorothy;

    @MockBean
    RestTemplate restTemplate;

    @Value("${wizard.url}")
    String url;

    @Test
    void findWayHome() {
        String homeUrl = "homeUrl";
        Mockito.when(restTemplate.getForObject(url, String.class)).thenReturn(homeUrl);
        dorothy.findWayHome();
        Mockito.verify(restTemplate).getForObject(url, String.class);
        Mockito.verify(restTemplate).getForObject(homeUrl, String.class);
    }
}