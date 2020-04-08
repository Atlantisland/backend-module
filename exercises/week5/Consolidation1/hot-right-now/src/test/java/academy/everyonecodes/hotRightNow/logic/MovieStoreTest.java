package academy.everyonecodes.hotRightNow.logic;

import academy.everyonecodes.hotRightNow.domain.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class MovieStoreTest {

    @Autowired
    MovieStore movieStore;

    @Test
    void getMovie() {
        Set<Movie> result = movieStore.getMovies();
        Set<Movie> expected = Set.of(new Movie("title1", "synopsis1"), new Movie("title2", "synopsis2"));
        Assertions.assertEquals(expected, result);
    }
}
