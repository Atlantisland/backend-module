package academy.everyoncecodes.drhouseTreatments.communication.endpoint;

import academy.everyoncecodes.drhouseTreatments.domain.Patient;
import academy.everyoncecodes.drhouseTreatments.logic.Nurse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {

    private final Nurse nurse;

    public PatientEndpoint(Nurse nurse) {
        this.nurse = nurse;
    }

    @PostMapping
    Patient post(@RequestBody Patient patient) {
        nurse.treat(patient);
        return patient;
    }
}
