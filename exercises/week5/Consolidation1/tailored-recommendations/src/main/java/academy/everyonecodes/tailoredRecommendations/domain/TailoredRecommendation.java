package academy.everyonecodes.tailoredRecommendations.domain;

import java.util.Objects;

public class TailoredRecommendation {

    private String userUuid;
    private Movie movie;

    TailoredRecommendation() {
    }

    public TailoredRecommendation(String userUuid, Movie movie) {
        this.userUuid = userUuid;
        this.movie = movie;
    }

    public String getUserUuid() {
        return userUuid;
    }

    void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public Movie getMovie() {
        return movie;
    }

    void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TailoredRecommendation that = (TailoredRecommendation) o;
        return Objects.equals(userUuid, that.userUuid) &&
                Objects.equals(movie, that.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userUuid, movie);
    }
}
