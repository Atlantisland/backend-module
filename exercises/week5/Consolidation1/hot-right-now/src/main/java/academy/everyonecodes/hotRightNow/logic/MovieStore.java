package academy.everyonecodes.hotRightNow.logic;

import academy.everyonecodes.hotRightNow.domain.Movie;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties("hotrightnow")
public class MovieStore {

    private List<Movie> movies;

    void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
