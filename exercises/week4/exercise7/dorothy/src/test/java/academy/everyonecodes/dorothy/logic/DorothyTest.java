package academy.everyonecodes.dorothy.logic;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)

class DorothyTest {

    @Autowired
    Dorothy dorothy;

    @MockBean
    RestTemplate restTemplate;

    @Value("${wizard.url}")
    String wizardUrl;

    @Test
    void findHome() {
        String homeUrl = "homeUrl";
        when(restTemplate.getForObject(wizardUrl, String.class))
                .thenReturn(homeUrl);
        String home = "Home";
        when(restTemplate.getForObject(homeUrl, String.class))
                .thenReturn(home);

        String result = dorothy.findHome();

        String expected = "My home is " + home;
        assertEquals(expected, result);
        verify(restTemplate).getForObject(wizardUrl, String.class);
        verify(restTemplate).getForObject(homeUrl, String.class);
    }
}
