package academy.everyoncecodes.drhouseTreatments.logic;

import academy.everyoncecodes.drhouseTreatments.domain.Patient;
import academy.everyoncecodes.drhouseTreatments.domain.Treatment;
import academy.everyoncecodes.drhouseTreatments.repository.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {

    private final TreatmentRepository repository;

    public TreatmentService(TreatmentRepository repository) {
        this.repository = repository;
    }

    public Patient post(Treatment treatment) {
        Patient patient = new Patient();
        patient.setTreatment(treatment.getTreatment());
        repository.save(treatment);
        return patient;
    }

    public List<Treatment> getAllTreatments() {
        return repository.findAllByTreatment();
    }

    public List<Treatment> getAllTreatmentsByUuid(String uuid) {
        return repository.finaAllByUuid(uuid);
    }
}

