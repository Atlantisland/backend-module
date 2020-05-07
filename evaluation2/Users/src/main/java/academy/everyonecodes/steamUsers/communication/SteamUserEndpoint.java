package academy.everyonecodes.steamUsers.communication;

import academy.everyonecodes.steamUsers.logic.SteamUserService;
import academy.everyonecodes.steamUsers.peristence.domain.SteamUser;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Secured("ROLE_APP")
public class SteamUserEndpoint {

    private final SteamUserService service;

    public SteamUserEndpoint(SteamUserService service) {
        this.service = service;
    }

    @PostMapping
    SteamUser post(@RequestBody SteamUser steamUser) {
        return service.save(steamUser);
    }
}
