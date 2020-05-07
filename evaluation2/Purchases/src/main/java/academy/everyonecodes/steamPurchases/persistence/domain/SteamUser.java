package academy.everyonecodes.steamPurchases.persistence.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class SteamUser {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Game> games = new HashSet<>();

    public SteamUser() {
    }

    public SteamUser(String username, Set<Game> games) {
        this.username = username;
        this.games = games;
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

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SteamUser steamUser = (SteamUser) o;
        return Objects.equals(id, steamUser.id) &&
                Objects.equals(username, steamUser.username) &&
                Objects.equals(games, steamUser.games);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, games);
    }
}
