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

    private final PatientService service;

    public PatientEndpoint(PatientService service) {
        this.service = service;
    }

    @PostMapping
    PatientDto post(@RequestBody PatientDto patientDTO) {
        service.invoice(patientDTO);
        return patientDTO;
    }
}

