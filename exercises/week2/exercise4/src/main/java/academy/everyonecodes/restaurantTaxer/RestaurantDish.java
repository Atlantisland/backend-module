package academy.everyonecodes.restaurantTaxer;

public class RestaurantDish {
    private String name;
    private double price;

    public RestaurantDish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
