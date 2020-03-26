package academy.everyonecodes.interactions.communication;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/negation")
public class NegationEndpoint {

    @PostMapping
    boolean post(@RequestBody boolean choice) {
        return !choice;
    }
}
