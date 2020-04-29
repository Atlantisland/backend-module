package academy.everyoncecodes.neverTooLate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MessageEndpoint {

    private final String message;

    public MessageEndpoint(@Value("${messages.message}") String message) {
        this.message = message;
    }

    @GetMapping
    String get() {
        return message;
    }
}
