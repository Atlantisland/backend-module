package academy.everyonecodes.tailoredRecommendations.communication;

import academy.everyonecodes.tailoredRecommendations.domain.Movie;
import academy.everyonecodes.tailoredRecommendations.domain.TailoredRecommendation;
import academy.everyonecodes.tailoredRecommendations.logic.TailoredRecommendationsStore;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TailoredRecommendationsEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    TailoredRecommendationsStore tailoredRecommendationsStore;

    Movie test1 = new Movie("title1", "synopsis1");
    TailoredRecommendation tailoredRecommendation = new TailoredRecommendation("123abc", test1);

    String url = "/tailoredrecommendations";
    String userUuid = "userUuid";

    @Test
    void get() {
        restTemplate.getForObject( url +"/" + userUuid, Movie[].class);
        Mockito.verify(tailoredRecommendationsStore).getMovie(userUuid);
    }

    @Test
    void post() {
        restTemplate.postForObject(url, tailoredRecommendation, TailoredRecommendation.class);
        Mockito.verify(tailoredRecommendationsStore).post(tailoredRecommendation);
    }
}