package academy.everyonecodes.registrations.communication;

import academy.everyonecodes.registrations.logic.UdemyUserService;
import academy.everyonecodes.registrations.presistence.domain.UdemyUser;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UdemyUserEndpoint {

    private final UdemyUserService udemyUserService;

    public UdemyUserEndpoint(UdemyUserService udemyUserService) {
        this.udemyUserService = udemyUserService;
    }

    @GetMapping
    @Secured("ROLE_ADMIN")
    List<UdemyUser> get(){
        return udemyUserService.findAll();
    }
}
