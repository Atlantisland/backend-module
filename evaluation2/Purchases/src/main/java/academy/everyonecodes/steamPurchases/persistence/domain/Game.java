package academy.everyonecodes.steamPurchases.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Game {

    @Id
    @GeneratedValue
    private Long id;

    private String gameName;

    @Column(unique = true)
    private String uuid;

    private double price;

    public Game() {
    }

    public Game(String gameName, String uuid, double price) {
        this.gameName = gameName;
        this.uuid = uuid;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
        Game game = (Game) o;
        return Double.compare(game.price, price) == 0 &&
                Objects.equals(id, game.id) &&
                Objects.equals(gameName, game.gameName) &&
                Objects.equals(uuid, game.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gameName, uuid, price);
    }
}
