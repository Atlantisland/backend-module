package academy.everyonecodes.steamPurchases.persistence.repository;

import academy.everyonecodes.steamPurchases.persistence.domain.SteamUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SteamUserRepository extends JpaRepository<SteamUser, Long> {

    Optional<SteamUser> findOneByUsername(String username);
}
