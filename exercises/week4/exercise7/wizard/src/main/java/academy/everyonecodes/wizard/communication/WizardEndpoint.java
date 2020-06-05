package academy.everyonecodes.wizard.communication;

import academy.everyonecodes.wizard.logic.Wizard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wizard")
public class WizardEndpoint {

    private final Wizard wizard;

    public WizardEndpoint(Wizard wizard) {
        this.wizard = wizard;
    }

    @GetMapping
    String get(){
        return wizard.getHomeUrl();
    }
}

