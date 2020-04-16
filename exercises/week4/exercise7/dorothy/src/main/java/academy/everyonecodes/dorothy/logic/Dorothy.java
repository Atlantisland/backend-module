package academy.everyonecodes.dorothy.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class Dorothy {

    private final RestTemplate restTemplate;
    private final String wizardUrl;

    public Dorothy(RestTemplate restTemplate,
                   @Value("${wizard.url}") String wizardUrl) {
        this.restTemplate = restTemplate;
        this.wizardUrl = wizardUrl;
    }

    public String findHome() {
        String homeUrl = restTemplate.getForObject(wizardUrl, String.class);
        String home = restTemplate.getForObject(homeUrl, String.class);
        return "My home is " + home;
    }
}


