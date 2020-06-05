package academy.everyonecodes.marathonIntegration.communication.client;

import academy.everyonecodes.marathonIntegration.domain.Runner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Controller
public class MarathonClient {

    private final RestTemplate restTemplate;
    private final String winnerUrl;
    private final String runnersUrl;

    public MarathonClient(RestTemplate restTemplate,
                          @Value("${marathon.winner.url}") String winnerUrl,
                          @Value("${marathon.runners.url}") String runnersUrl) {
        this.restTemplate = restTemplate;
        this.winnerUrl = winnerUrl;
        this.runnersUrl = runnersUrl;
    }

    public Optional<Runner> getWinner(){
        return Optional.ofNullable(restTemplate.getForObject(winnerUrl, Runner.class));
    }

    public Runner post(Runner runner){
        return restTemplate.postForObject(runnersUrl, runner, Runner.class);
    }
}
