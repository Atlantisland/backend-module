package academy.everyonecodes.drivers.presistence.repository;

import academy.everyonecodes.drivers.presistence.domain.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DriverRepository extends MongoRepository<Driver, String> {

    Optional<Driver> findOneByUsername(String username);
}
