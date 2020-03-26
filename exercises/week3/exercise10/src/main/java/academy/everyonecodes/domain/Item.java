package academy.everyonecodes.domain;

import java.util.Objects;

public class Item {

    private String name;
    private double price;

    Item() {
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 &&
                Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
