package academy.everyonecodes.registrations.communication;

import academy.everyonecodes.registrations.logic.RegistrationService;
import academy.everyonecodes.registrations.presistence.domain.Registration;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class RegistrationEndpoint {

    private final RegistrationService registrationService;

    public RegistrationEndpoint(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    @Secured("ROLE_APP")
    Registration post(@RequestBody Registration registration) {
        return registrationService.link(registration);
    }
}
