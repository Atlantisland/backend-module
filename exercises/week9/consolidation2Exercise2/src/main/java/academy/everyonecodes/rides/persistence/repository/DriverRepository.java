package academy.everyonecodes.rides.persistence.repository;

import academy.everyonecodes.rides.persistence.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
