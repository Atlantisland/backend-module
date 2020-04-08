package academy.everyonecodes.communication.client;

import academy.everyonecodes.domain.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@Controller
public class HotRightnowClient {

    private final RestTemplate restTemplate;
    private final String hotUrl;

    public HotRightnowClient(RestTemplate restTemplate, @Value("${hotrightnow.url}") String hotUrl) {
        this.restTemplate = restTemplate;
        this.hotUrl = hotUrl;
    }

    public Set<Movie> getMovies(){
        Movie[] response = restTemplate.getForObject(hotUrl, Movie[].class);
        return Set.of(response);
    }
}
