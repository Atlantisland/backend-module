package academy.everyonecodes.logic;

import academy.everyonecodes.communication.client.HotRightnowClient;
import academy.everyonecodes.communication.client.TailoredRecommendationsClient;
import academy.everyonecodes.domain.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void getRecommendationsFindsNothing() {
        String userUuid = "testUuid";
        List<Movie> expected = List.of();
        when(tailoredRecommendationsClient.getTailoredRecommendations(userUuid))
                .thenReturn(expected);
        when(hotRightnowClient.getRecommendations(userUuid))
                .thenReturn(expected);

        List<Movie> result = recommendationService.getMovieByUuid(userUuid);

        assertEquals(expected, result);
        verify(tailoredRecommendationsClient).getTailoredRecommendations(userUuid);
        verify(hotRightnowClient).getRecommendations(userUuid);
    }

    @Test
    void getRecommendationsFindsHotRightNow() {
        String userUuid = "testUuid";
        when(tailoredRecommendationsClient.getTailoredRecommendations(anyString()))
                .thenReturn(new ArrayList<>());
        List<Movie> expected = List.of(new Movie("test", "test"));
        when(hotRightnowClient.getRecommendations(anyString()))
                .thenReturn(expected);

        List<Movie> result = recommendationService.getMovieByUuid(userUuid);

        assertEquals(expected, result);
        verify(tailoredRecommendationsClient).getTailoredRecommendations(userUuid);
        verify(hotRightnowClient).getRecommendations(userUuid);
    }

    @Test
    void getRecommendationsFindsTailoredRecommendations() {
        String userUuid = "testUuid";
        List<Movie> expected = List.of(new Movie("test", "test"));
        when(tailoredRecommendationsClient.getTailoredRecommendations(anyString()))
                .thenReturn(expected);

        List<Movie> result = recommendationService.getMovieByUuid(userUuid);

        assertEquals(expected, result);
        verify(tailoredRecommendationsClient).getTailoredRecommendations(userUuid);
        verify(hotRightnowClient, never()).getRecommendations(userUuid);
    }

}