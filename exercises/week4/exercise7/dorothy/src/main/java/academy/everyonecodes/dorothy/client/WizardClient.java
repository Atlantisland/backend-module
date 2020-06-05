package academy.everyonecodes.dorothy.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class WizardClient {

    private final RestTemplate restTemplate;
    private final String wizardUrl;

    public WizardClient(RestTemplate restTemplate, @Value("${wizard.url}") String wizardUrl) {
        this.restTemplate = restTemplate;
        this.wizardUrl = wizardUrl;
    }

    public String getHomeUrl(){
        return restTemplate.getForObject(wizardUrl, String.class);
    }
}
