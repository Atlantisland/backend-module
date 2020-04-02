package academy.everyonecodes.marathonIntegration.communication.client;

import academy.everyonecodes.marathonIntegration.domain.Runner;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class MarathonClientTest {

    @Autowired
    MarathonClient marathonClient;

    @MockBean
    RestTemplate restTemplate;
    @Value("${marathon.webapp.url}")
    String url;

    @Test
    void getWinner() {
        marathonClient.getWinner();
        Mockito.verify(restTemplate).getForObject(url + "/winner", Runner.class);
    }

    @Test
    void post() {
        Runner testRunner = new Runner("testRunner", Duration.ofSeconds(1));
        marathonClient.post(testRunner);
        Mockito.verify(restTemplate).postForObject(url, testRunner, Runner.class);
    }
}