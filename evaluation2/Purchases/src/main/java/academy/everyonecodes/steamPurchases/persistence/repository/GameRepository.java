package academy.everyonecodes.steamPurchases.persistence.repository;

import academy.everyonecodes.steamPurchases.persistence.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
