package academy.everyonecodes.drhouseAccountancy.persistence.repository;

import academy.everyonecodes.drhouseAccountancy.persistence.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByUuid(String uuid);
}
