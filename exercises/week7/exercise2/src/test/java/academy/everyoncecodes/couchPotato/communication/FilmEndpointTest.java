package academy.everyoncecodes.couchPotato.communication;

import academy.everyoncecodes.couchPotato.domain.Film;
import academy.everyoncecodes.couchPotato.repository.FilmRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FilmEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    FilmRepository filmRepository;

    String url = "/films";

    @Test
    void get() {
        testRestTemplate.getForObject(url, Film[].class);

        verify(filmRepository).findAll();
    }

    @Test
    void post() {
        Film film = new Film("Arrival", 1);

        testRestTemplate.postForObject(url, film, Film.class);

        verify(filmRepository).save(film);
    }

}