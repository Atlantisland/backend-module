package academy.everyonecodes.marathonIntegration.communication.client;

import academy.everyonecodes.marathonIntegration.domain.Runner;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class MarathonClientTest {

    @Autowired
    MarathonClient marathonClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${marathon.winner.url}")
    String winnerUrl;

    @Value("${marathon.runners.url}")
    String runnersUrl;

    @Autowired
    Runner winner;

    @Test
    void getWinner() {
        when(restTemplate.getForObject(winnerUrl, Runner.class))
                .thenReturn(winner);

        Optional<Runner> oWinner = marathonClient.getWinner();

        Optional<Runner> oExpected = Optional.of(this.winner);
        assertEquals(oExpected, oWinner);
        Mockito.verify(restTemplate).getForObject(winnerUrl, Runner.class);
    }

    @Test
    void post() {
        when(restTemplate.postForObject(runnersUrl, winner, Runner.class))
                .thenReturn(winner);

        Runner response = marathonClient.post(winner);

        assertEquals(winner, response);
        Mockito.verify(restTemplate).postForObject(runnersUrl, winner, Runner.class);
    }
}