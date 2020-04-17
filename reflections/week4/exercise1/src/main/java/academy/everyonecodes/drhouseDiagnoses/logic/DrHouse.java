package academy.everyonecodes.drhouseDiagnoses.logic;

import academy.everyonecodes.drhouseDiagnoses.domain.Diagnosis;
import academy.everyonecodes.drhouseDiagnoses.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrHouse {

    private final List<Diagnosis> diagnoses;

    public DrHouse(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public void diagnose(Patient patient) {
        String diagnosis = findDiagnosis(patient);
        patient.setDiagnosis(diagnosis);
    }

    private String findDiagnosis(Patient patient) {
        return diagnoses.stream().filter(diagnosis -> diagnosis.getSymptoms().equalsIgnoreCase(patient.getSymptoms()))
                .map(Diagnosis::getName)
                .findFirst()
                .orElse("lupus");
    }
}

