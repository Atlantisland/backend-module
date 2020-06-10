package academy.everyonecodes.hotRightNow.logic;

import academy.everyonecodes.hotRightNow.domain.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class MovieStoreTest {

    @Autowired
    MovieStore movieStore;

    @Test
    void getMovie() {
        List<Movie> result = movieStore.getMovies();

        assertEquals(1, result.size());
        Movie expected = new Movie("title1", "synopsis1");
        Assertions.assertEquals(expected, result.get(0));
    }
}
