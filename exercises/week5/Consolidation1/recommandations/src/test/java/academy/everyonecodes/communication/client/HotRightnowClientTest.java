package academy.everyonecodes.communication.client;

import academy.everyonecodes.domain.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class HotRightnowClientTest {

    @Autowired
    HotRightnowClient hotRightnowClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${hotrightnow.url}")
    String hotUrl;

    Movie movie = new Movie("title", "synopsis");

    @Test
    void getMovies() {
        when(hotRightnowClient.getMovies()).thenReturn(Set.of(movie));
        Set<Movie> result = hotRightnowClient.getMovies();
        Assertions.assertEquals(Set.of(movie), result);
        verify(restTemplate).getForObject(hotUrl, Movie[].class);
    }
}