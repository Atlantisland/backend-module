package academy.everyonecodes.restaurantTaxer;

import java.util.List;

public abstract class Taxer {

    private List<String> names;
    private double tax;

    public Taxer(List<String> names, double tax) {
        this.names = names;
        this.tax = tax;
    }

    public boolean matches(RestaurantDish dish){
        return names.contains(dish.getName());
    }

    public double tax(RestaurantDish dish){
        return dish.getPrice()+tax;
    }
}
