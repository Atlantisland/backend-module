package academy.everyoncecodes.drhouseTreatments.communication.client;

import academy.everyoncecodes.drhouseTreatments.domain.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class AccountyncyClient {

    private final RestTemplate restTemplate;
    private final String url;

    public AccountyncyClient(RestTemplate restTemplate,
                             @Value("${drhouse.accountancy.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public void send(Patient patient) {
        restTemplate.postForObject(url, patient, Void.class);
    }
}
