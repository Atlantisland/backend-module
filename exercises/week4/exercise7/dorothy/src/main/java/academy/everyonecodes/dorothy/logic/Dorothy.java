package academy.everyonecodes.dorothy.logic;

import academy.everyonecodes.dorothy.client.HomeClient;
import academy.everyonecodes.dorothy.client.WizardClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Dorothy {

    private final WizardClient wizardClient;
    private final HomeClient homeClient;
    private final String message;

    public Dorothy(WizardClient wizardClient,
                   HomeClient homeClient,
                   @Value("${dorothy.message}") String message) {
        this.wizardClient = wizardClient;
        this.homeClient = homeClient;
        this.message = message;
    }

    public String getMessage() {
        String homeUrl = wizardClient.getHomeUrl();
        String homeMessage = homeClient.getHomeMessage(homeUrl);
        return message + homeMessage;
    }
}


