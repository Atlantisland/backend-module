package academy.everyonecodes.dorothy.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class Dorothy {
    private final RestTemplate restTemplate;
    private final String wizardUrl;

    public Dorothy(RestTemplate restTemplate, @Value("${wizard.url}") String wizardUrl) {
        this.restTemplate = restTemplate;
        this.wizardUrl = wizardUrl;
    }

    public String findWayHome() {
        String result = "My home is ";
        String homeUrl = askWizard();
        String nameOfHome = askHome(homeUrl);
        return result + nameOfHome;
    }

    private String askHome(String homeUrl) {
        return restTemplate.getForObject(homeUrl, String.class);
    }

    private String askWizard() {
        return restTemplate.getForObject(wizardUrl, String.class);
    }


}

