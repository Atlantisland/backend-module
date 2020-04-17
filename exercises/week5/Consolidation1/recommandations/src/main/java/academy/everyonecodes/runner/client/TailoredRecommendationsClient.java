package academy.everyonecodes.runner.client;

import academy.everyonecodes.domain.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

@Controller
public class TailoredRecommendationsClient {

    private final RestTemplate restTemplate;
    private final String tailoredUrl;

    public TailoredRecommendationsClient(RestTemplate restTemplate, @Value("${tailoredRecommendations.url}") String tailoredUrl) {
        this.restTemplate = restTemplate;
        this.tailoredUrl = tailoredUrl;
    }

    public Set<Movie> getTailoredRecommendations(String uuid) {
        return restTemplate.getForObject(tailoredUrl, HashSet.class);

    }
}