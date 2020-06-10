package academy.everyonecodes.communication.client;

import academy.everyonecodes.domain.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Controller
public class TailoredRecommendationsClient {

    private final RestTemplate restTemplate;
    private final String url;

    public TailoredRecommendationsClient(RestTemplate restTemplate,
                                         @Value("${tailoredRecommendations.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public List<Movie> getTailoredRecommendations(String uuid) {
        String tailoredUrl = url + "/" + uuid;
        Movie[] movies = restTemplate.getForObject(tailoredUrl, Movie[].class);
        return Stream.of(movies)
                .collect(toList());
    }
}
