package academy.everyonecodes.mocky.communication;

import academy.everyonecodes.mocky.domain.Postcard;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("mocky/postcards")
public class MockyPostcardsEndpoint {

    private final RestTemplate restTemplate;
    private final String oneUrl;
    private final List<String> twoUrls;


    public MockyPostcardsEndpoint(RestTemplate restTemplate, @Value("${mocky.url.postcards.one}") String oneUrl, @Value("${mocky.url.postcards.two}") List<String> twoUrls) {
        this.restTemplate = restTemplate;
        this.oneUrl = oneUrl;
        this.twoUrls = twoUrls;
    }

    @GetMapping("/1")
    Postcard getOne() {
        return restTemplate.getForObject(oneUrl, Postcard.class);
    }


    @GetMapping("/2")
    List<Postcard> getTwo() {
        return twoUrls.stream()
                .map(url -> restTemplate.getForObject(url, Postcard.class))
                .collect(toList());
    }
}
