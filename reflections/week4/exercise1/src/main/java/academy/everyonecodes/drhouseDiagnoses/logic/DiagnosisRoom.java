package academy.everyonecodes.drhouseDiagnoses.logic;

import academy.everyonecodes.drhouseDiagnoses.domain.Patient;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisRoom {

    private final DrHouse drHouse;


    public DiagnosisRoom(DrHouse drHouse) {
        this.drHouse = drHouse;
    }

    public Patient diagnose (Patient patient){

    }
}
