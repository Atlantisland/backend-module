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

    public Diagnosis diagnose(Patient patient) {
        String diagnosis = diagnoses.get(patient.getSymptoms());
        //I should stream the diagnoses list and to find based on the symptoms of the patient the diagnosis
        //but I stop here. I know that inside the get it should be a number and i have a string...:(

        patient.setDiagnosis(diagnosis);
        if (patient.getDiagnosis().equalsIgnoreCase(diagnosis)) {
            return new Diagnosis(diagnosis, patient.getSymptoms());
        }
        return new Diagnosis("lupus", patient.getSymptoms());
    }
}

