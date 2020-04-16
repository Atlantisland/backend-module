package academy.everyonecodes.repository;

import academy.everyonecodes.domain.Accumulation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccumulationRepository extends MongoRepository<Accumulation, String> {
}

