package academy.everyonecodes.basicyml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Message {
    private String message;

    public Message(@Value("${basic.message}") String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
