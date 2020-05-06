package academy.everyonecodes.drivers.presistence.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Driver {

    private String id;
    private String username;
    private String password;
    private String typeOfCar;
    private boolean isAvailable;
    private Set<String> authorities = new HashSet<>();

    public Driver() {
    }

    public Driver(String username, String password, String typeOfCar, boolean isAvailable, Set<String> authorities) {
        this.username = username;
        this.password = password;
        this.typeOfCar = typeOfCar;
        this.isAvailable = isAvailable;
    }

    public Driver(String id, String username, String password, String typeOfCar, boolean isAvailable, Set<String> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.typeOfCar = typeOfCar;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return isAvailable == driver.isAvailable &&
                Objects.equals(id, driver.id) &&
                Objects.equals(username, driver.username) &&
                Objects.equals(password, driver.password) &&
                Objects.equals(typeOfCar, driver.typeOfCar) &&
                Objects.equals(authorities, driver.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, typeOfCar, isAvailable, authorities);
    }
}


