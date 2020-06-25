package academy.everyonecodes.udemyUsers.peristence.repository;

import academy.everyonecodes.udemyUsers.peristence.domain.UdemyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UdemyUserRepository extends JpaRepository<UdemyUser, Long> {

    Optional<UdemyUser> findOneByUsername(String username);

    boolean existsByUsername(String username);
}
