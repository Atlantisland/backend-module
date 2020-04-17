package academy.everyoncecodes.drhouseTreatments.repository;

import academy.everyoncecodes.drhouseTreatments.domain.Treatment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TreatmentRepository extends MongoRepository<Treatment, String> {

    List<Treatment> finaAllByUuid(String uuid);

    List<Treatment> findAllByTreatment();

}
