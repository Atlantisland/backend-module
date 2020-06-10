package academy.everyonecodes.tailoredRecommendations.domain;

import java.util.Objects;

public class Movie {

    private String title;
    private String synopsis;

    Movie() {
    }

    public Movie(String title, String synopsis) {
        this.title = title;
        this.synopsis = synopsis;
    }

    public String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) &&
                Objects.equals(synopsis, movie.synopsis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, synopsis);
    }
}
