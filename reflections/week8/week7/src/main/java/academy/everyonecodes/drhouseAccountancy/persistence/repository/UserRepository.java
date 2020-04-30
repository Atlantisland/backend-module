package academy.everyonecodes.drhouseAccountancy.persistence.repository;

import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    boolean existsByUsername(String username);

    Optional<User> findOneByUsername(String username);
}

//I need to update the pom.xml for mongo but due to time I decide to move on and when
//there is still time left I will be back to update it.