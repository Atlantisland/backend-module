package academy.everyonecodes.theThievesDen;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/treasures")
public class TreasuresEndpoint {

    private final String message;

    public TreasuresEndpoint(@Value("${treasures.message}") String message) {
        this.message = message;
    }

    @GetMapping
    String get() {
        return message;
    }
}
