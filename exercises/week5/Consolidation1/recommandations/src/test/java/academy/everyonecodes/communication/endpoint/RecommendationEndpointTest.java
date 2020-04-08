package academy.everyonecodes.communication.endpoint;

import academy.everyonecodes.domain.Movie;
import academy.everyonecodes.logic.RecommendationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RecommendationEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    RecommendationService service;

    String url = "/recommendations";


    @Test
    void get(){
        String userUuid = "userUuid";
        testRestTemplate.getForObject(url, Movie[].class);

        verify(service).getMovieByUuid(userUuid);
    }
}