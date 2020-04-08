package academy.everyonecodes.hotRightNow.logic;

import academy.everyonecodes.hotRightNow.domain.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@ConfigurationProperties("hotrightnow")
public class MovieStore {

    private Set<Movie> movies;

    void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Set<Movie> getMovies() {
        return movies;
    }
}
