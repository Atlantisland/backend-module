package academy.everyonecodes.marathonIntegration.communication.client;

import academy.everyonecodes.marathonIntegration.domain.Runner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Controller
public class MarathonClient {

    private final RestTemplate restTemplate;
    private final String url;


    public MarathonClient(RestTemplate restTemplate, @Value("${marathon.webapp.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public Optional<Runner> getWinner(){
        return Optional.ofNullable(restTemplate.getForObject(url +"/winner", Runner.class));
    }

    public Runner post(Runner runner){
        return restTemplate.postForObject(url, runner, Runner.class);
    }
}
