package academy.everyonecodes.drhouseDiagnoses.communication;

import academy.everyonecodes.drhouseDiagnoses.domain.Patient;
import academy.everyonecodes.drhouseDiagnoses.logic.DrHouse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {

    private final DrHouse drHouse;

    public PatientEndpoint(DrHouse drHouse) {
        this.drHouse = drHouse;
    }

    @PostMapping
    Patient postDiagnosedPatient(@RequestBody Patient patient) {
        drHouse.diagnose(patient);
        return patient;
    }
}
