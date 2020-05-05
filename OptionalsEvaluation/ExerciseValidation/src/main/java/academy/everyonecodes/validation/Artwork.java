package academy.everyonecodes.validation;

import javax.validation.constraints.NotEmpty;

public class Artwork {

    @NotEmpty
    private String name;

    private Rating rating;

    public Artwork(String name, Rating rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}


