package academy.everyonecodes.home.communication;

import academy.everyonecodes.home.logic.Home;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeEndpoint {

    private final Home home;

    public HomeEndpoint(Home home) {
        this.home = home;
    }

    @GetMapping
    String get() {
        return home.getMessage();
    }
}
