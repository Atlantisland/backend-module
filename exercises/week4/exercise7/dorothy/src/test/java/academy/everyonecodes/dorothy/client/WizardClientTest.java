package academy.everyonecodes.dorothy.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class WizardClientTest {

    @Autowired
    WizardClient wizardClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${wizard.url}")
    String wizardUrl;

    @Test
    void getHomeUrl(){
        wizardClient.getHomeUrl();

        verify(restTemplate).getForObject(wizardUrl, String.class);
    }
}