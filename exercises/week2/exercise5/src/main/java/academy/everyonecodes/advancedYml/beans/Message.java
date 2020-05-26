package academy.everyonecodes.advancedYml.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("advanced")
public class Message {

    private String message;

    public String getMessage() {
        return message;
    }

    void setMessage(String message) {
        this.message = message;
    }
}
