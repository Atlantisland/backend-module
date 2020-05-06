package academy.everyonecodes.rides.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Ride {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private double distance;
    private double price;

    public Ride() {
    }

    public Ride(String username, double distance, double price) {
        this.username = username;
        this.distance = distance;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return Double.compare(ride.distance, distance) == 0 &&
                Double.compare(ride.price, price) == 0 &&
                Objects.equals(id, ride.id) &&
                Objects.equals(username, ride.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, distance, price);
    }
}
