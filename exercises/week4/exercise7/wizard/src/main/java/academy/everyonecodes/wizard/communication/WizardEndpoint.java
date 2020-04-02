package academy.everyonecodes.wizard.communication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wizard")
public class WizardEndpoint {
    private final String homeUrl;

    public WizardEndpoint(@Value("${home.url}") String homeUrl) {
        this.homeUrl = homeUrl;
    }


    @GetMapping
    String get() {
        return homeUrl;
    }
}

