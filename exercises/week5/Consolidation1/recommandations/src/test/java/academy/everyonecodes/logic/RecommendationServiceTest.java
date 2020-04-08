package academy.everyonecodes.logic;

import academy.everyonecodes.communication.client.HotRightnowClient;
import academy.everyonecodes.communication.client.TailoredRecommendationsClient;
import academy.everyonecodes.domain.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class RecommendationServiceTest {

    @Autowired
    RecommendationService recommendationService;

    @MockBean
    TailoredRecommendationsClient tailoredRecommendationsClient;

    @MockBean
    HotRightnowClient hotRightnowClient;

    String uuid = "uuid";
    Movie movie = new Movie("title", "synopsis");

    @Test
    void getMovieByUuid() {
        when(tailoredRecommendationsClient.getTailoredRecommendations(uuid)).thenReturn(Set.of(movie));
        Set<Movie> result = recommendationService.getMovieByUuid(uuid);
        Assertions.assertEquals(Set.of(movie), result);
        verify(tailoredRecommendationsClient).getTailoredRecommendations(uuid);
        verify(hotRightnowClient, never()).getMovies();
    }

    @Test
    void getHotRightNowRecommandations() {
        when(tailoredRecommendationsClient.getTailoredRecommendations(uuid)).thenReturn(Set.of());
        when(hotRightnowClient.getMovies()).thenReturn(Set.of(movie));
        Set<Movie> result = recommendationService.getMovieByUuid(uuid);
        Assertions.assertEquals(Set.of(movie), result);
        verify(tailoredRecommendationsClient).getTailoredRecommendations(uuid);
        verify(hotRightnowClient).getMovies();
    }
}