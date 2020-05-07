package academy.everyonecodes.steamUsers.communication;

import academy.everyonecodes.steamUsers.logic.SteamUserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Secured("ROLE_USER")
public class MessageEndpoint {

    private final SteamUserService steamUserService;

    public MessageEndpoint(SteamUserService steamUserService) {
        this.steamUserService = steamUserService;
    }

    @GetMapping
    String post(){
        return steamUserService.login();
    }
}
