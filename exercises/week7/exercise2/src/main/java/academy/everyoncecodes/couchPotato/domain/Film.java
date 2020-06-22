package academy.everyoncecodes.couchPotato.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Film {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String name;

    @Min(1)
    @Max(5)
    private int rating;

    public Film(){
    }

    public Film(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return rating == film.rating &&
                Objects.equals(id, film.id) &&
                Objects.equals(name, film.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rating);
    }
}
