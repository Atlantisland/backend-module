package academy.everyonecodes.hotRightNow.communication;

import academy.everyonecodes.hotRightNow.domain.Movie;
import academy.everyonecodes.hotRightNow.logic.MovieStore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    MovieStore movieStore;

    String url = "/movies";

    @Test
    void get(){
        testRestTemplate.getForObject(url, Movie[].class);

        verify(movieStore).getMovies();
    }
}