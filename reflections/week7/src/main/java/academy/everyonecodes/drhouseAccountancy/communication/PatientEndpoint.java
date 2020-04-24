package academy.everyonecodes.drhouseAccountancy.communication;

import academy.everyonecodes.drhouseAccountancy.logic.PatientService;
import academy.everyonecodes.drhouseAccountancy.persistence.domain.PatientDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {

    private final PatientService patientService;

    public PatientEndpoint(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    PatientDto post(@RequestBody PatientDto patientDto){
        patientService.invoice(patientDto);
        return patientDto;
    }
}
