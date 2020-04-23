package academy.everyoncecodes.socialNetwork.persistence.repository;

import academy.everyoncecodes.socialNetwork.persistence.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
