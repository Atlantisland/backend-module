package academy.everyonecodes.domain;

import java.util.Objects;

public class Item {

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    void setPrice(double price) {
        this.price = price;
    }

}
