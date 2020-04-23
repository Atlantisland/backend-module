package academy.everyoncecodes.couchPotato.repository;

import academy.everyoncecodes.couchPotato.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
