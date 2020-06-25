package academy.everyonecodes.registrations.presistence.repository;

import academy.everyonecodes.registrations.presistence.domain.UdemyUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UdemyUserRepository extends MongoRepository<UdemyUser, String> {
    Optional<UdemyUser> findOneByUsername(String username);
}



