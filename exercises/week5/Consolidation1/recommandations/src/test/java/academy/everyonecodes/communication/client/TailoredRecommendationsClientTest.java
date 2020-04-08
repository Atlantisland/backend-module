package academy.everyonecodes.communication.client;

import academy.everyonecodes.domain.Movie;
import jdk.jfr.consumer.RecordedStackTrace;
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
class TailoredRecommendationsClientTest {

    @Autowired
    TailoredRecommendationsClient tailoredRecommendationsClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${tailoredRecommendations.url}")
    String tailoredUrl;

    String uuid = "uuid";
    Movie movie = new Movie("title", "synopsis");

    @Test
    void getTailoredRecommendations() {
        when(tailoredRecommendationsClient.getTailoredRecommendations(uuid)).thenReturn(Set.of(movie));
        Set<Movie> result = tailoredRecommendationsClient.getTailoredRecommendations(uuid);
        Assertions.assertEquals(Set.of(movie), result);
        verify(restTemplate).getForObject(tailoredUrl, Movie[].class);
    }
}