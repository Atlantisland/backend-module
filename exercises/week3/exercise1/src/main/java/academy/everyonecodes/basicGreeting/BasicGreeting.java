package academy.everyonecodes.basicGreeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BasicGreeting {

    @GetMapping
    String get(){
        return "Hello there!";
    }
}
