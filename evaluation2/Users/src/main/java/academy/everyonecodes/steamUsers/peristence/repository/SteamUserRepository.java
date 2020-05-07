package academy.everyonecodes.steamUsers.peristence.repository;

import academy.everyonecodes.steamUsers.peristence.domain.SteamUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SteamUserRepository extends MongoRepository<SteamUser, String> {

    Optional<SteamUser> findOneByUsername(String username);
    boolean existsByUsername(String username);
}
