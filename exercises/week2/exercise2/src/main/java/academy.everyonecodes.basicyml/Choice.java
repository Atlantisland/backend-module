package academy.everyonecodes.basicyml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Choice {
    private boolean choice;

    public Choice(@Value("${basic.choice}") boolean choice) {
        this.choice = choice;
    }

    public boolean getChoice() {
        return choice;
    }
}
