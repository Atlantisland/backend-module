package academy.everyonecodes.validation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Rating {

    @Min(1)
    @Max(5)
    private int stars;

    public Rating(int stars) {
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
