package academy.everyonecodes.steamPurchases.persistence.domain;

import java.util.Objects;

public class Purchase {

    private SteamUser steamUser;
    private Game game;

    public Purchase() {
    }

    public Purchase(SteamUser steamUser, Game game) {
        this.steamUser = steamUser;
        this.game = game;
    }

    public SteamUser getSteamUser() {
        return steamUser;
    }

    public void setSteamUser(SteamUser steamUser) {
        this.steamUser = steamUser;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(steamUser, purchase.steamUser) &&
                Objects.equals(game, purchase.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(steamUser, game);
    }
}
