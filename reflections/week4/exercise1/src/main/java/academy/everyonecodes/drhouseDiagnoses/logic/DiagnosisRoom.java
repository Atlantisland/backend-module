package academy.everyonecodes.drhouseDiagnoses.logic;

import academy.everyonecodes.drhouseDiagnoses.communication.TreatmentsClient;
import academy.everyonecodes.drhouseDiagnoses.domain.Patient;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisRoom {

    private final DrHouse drHouse;
    private final TreatmentsClient treatmentsClient;

    public DiagnosisRoom(DrHouse drHouse, TreatmentsClient treatmentsClient) {
        this.drHouse = drHouse;
        this.treatmentsClient = treatmentsClient;
    }

    public Patient diagnose(Patient patient) {
        drHouse.diagnose(patient);
        treatmentsClient.send(patient);
        return patient;
    }
}


