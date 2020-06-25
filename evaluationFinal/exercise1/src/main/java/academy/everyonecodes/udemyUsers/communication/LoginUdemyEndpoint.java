package academy.everyonecodes.udemyUsers.communication;

import academy.everyonecodes.udemyUsers.logic.LoginUdemyService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginUdemyEndpoint {

    private final LoginUdemyService loginUdemyService;

    public LoginUdemyEndpoint(LoginUdemyService loginUdemyService) {
        this.loginUdemyService = loginUdemyService;
    }

    @PostMapping
    @Secured("ROLE_USER")
    String post() {
        return loginUdemyService.login();
    }
}
