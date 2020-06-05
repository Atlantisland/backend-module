package academy.everyonecodes.dorothy.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeClient {

    private final RestTemplate restTemplate;

    public HomeClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getHomeMessage(String homeUrl){

        return restTemplate.getForObject(homeUrl, String.class);
    }
}
