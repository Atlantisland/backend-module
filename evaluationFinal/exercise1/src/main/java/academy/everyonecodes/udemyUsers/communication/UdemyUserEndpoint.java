package academy.everyonecodes.udemyUsers.communication;

import academy.everyonecodes.udemyUsers.logic.UdemyUserService;
import academy.everyonecodes.udemyUsers.peristence.domain.UdemyUser;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UdemyUserEndpoint {

    private final UdemyUserService udemyUserService;

    public UdemyUserEndpoint(UdemyUserService udemyUserService) {
        this.udemyUserService = udemyUserService;
    }

    @PostMapping
    @Secured("ROLE_APP")
    UdemyUser save(@RequestBody UdemyUser udemyUser){
        return udemyUserService.save(udemyUser);
    }
}
