package academy.everyonecodes.runner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number")
public class NumberEndpoint {

    @GetMapping
    int get() {
        return 42;
    }
}
