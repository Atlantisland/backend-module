package academy.everyonecodes.communication.client;

import academy.everyonecodes.domain.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Controller
public class HotRightnowClient {

    private final RestTemplate restTemplate;
    private final String url;

    public HotRightnowClient(RestTemplate restTemplate,
                             @Value("${hotrightnow.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public List<Movie> getRecommendations(String userUuid){
        Movie[] movies = restTemplate.getForObject(url, Movie[].class);
        return Stream.of(movies)
                .collect(toList());
    }
}
