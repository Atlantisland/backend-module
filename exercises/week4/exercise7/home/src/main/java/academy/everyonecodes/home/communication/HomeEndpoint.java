package academy.everyonecodes.home.communication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeEndpoint {
    private final String homeName;

    public HomeEndpoint(@Value("${homeName}") String homeName) {
        this.homeName = homeName;
    }

    @GetMapping
    String get() {
        return homeName;
    }
}
