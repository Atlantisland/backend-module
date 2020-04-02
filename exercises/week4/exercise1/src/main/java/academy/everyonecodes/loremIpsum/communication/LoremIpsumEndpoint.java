package academy.everyonecodes.loremIpsum.communication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/loremipsum")
public class LoremIpsumEndpoint {

    private final RestTemplate restTemplate;

    public LoremIpsumEndpoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    String get(){
        String url = "https://loripsum.net/api";
        return restTemplate.getForObject(url, String.class);
    }
}
