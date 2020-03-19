package academy.everyonecodes.advancedYml.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("advanced")
public class Choice {
    private boolean choice;

    public boolean getChoice() {
        return choice;
    }

    void setChoice(boolean choice) {
        this.choice = choice;
    }
}
