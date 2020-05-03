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

    public void save(Patient patient){
        Treatment treatment = createTreatment(patient);
        repository.save(treatment);
    }

    private Treatment createTreatment(Patient patient){
        return new Treatment(patient.getUuid(), patient.getName(), patient.getSymptoms(), patient.getDiagnosis(), patient.getTreatment());

    }

    public List<Treatment> findAll(){
        return repository.findAll();
    }

    public List<Treatment> findByUuid(String uuid){
        return repository.findByUuid(uuid);
    }
}

