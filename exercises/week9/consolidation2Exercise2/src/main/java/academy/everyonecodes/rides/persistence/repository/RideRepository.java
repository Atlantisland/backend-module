package academy.everyonecodes.rides.persistence.repository;

import academy.everyonecodes.rides.persistence.domain.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {
}
