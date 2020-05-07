package academy.everyonecodes.steamPurchases.logic;

import academy.everyonecodes.steamPurchases.persistence.domain.Game;
import academy.everyonecodes.steamPurchases.persistence.domain.Purchase;
import academy.everyonecodes.steamPurchases.persistence.domain.SteamUser;
import academy.everyonecodes.steamPurchases.persistence.repository.GameRepository;
import academy.everyonecodes.steamPurchases.persistence.repository.SteamUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PurchaseService {

    private final GameRepository gameRepository;
    private final SteamUserRepository steamUserRepository;

    public PurchaseService(GameRepository gameRepository, SteamUserRepository steamUserRepository) {
        this.gameRepository = gameRepository;
        this.steamUserRepository = steamUserRepository;
    }

    public Purchase purchase(Purchase purchase) {
        SteamUser purchasedUser = purchase.getSteamUser();
        Game purchasedGame = purchase.getGame();
        gameRepository.save(purchasedGame);
        Optional<SteamUser> oSteamUser = steamUserRepository.findOneByUsername(purchasedUser.getUsername());
        if(oSteamUser.isEmpty()){
             Set<Game> games = purchasedUser.getGames();
             games.add(purchasedGame);
             steamUserRepository.save(purchasedUser);
            return new Purchase(purchasedUser, purchasedGame);
        }
        SteamUser savedUser=oSteamUser.get();
        Set<Game> games = savedUser.getGames();
        games.add(purchasedGame);
        steamUserRepository.save(savedUser);
        return new Purchase(savedUser, purchasedGame);
    }

    public List<SteamUser> findAllSteamUsers() {
        return steamUserRepository.findAll();
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }
}
