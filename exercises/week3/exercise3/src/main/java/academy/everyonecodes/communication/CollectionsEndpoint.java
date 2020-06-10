package academy.everyonecodes.runner;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/collections")
public class CollectionsEndpoint {

    @GetMapping("/texts")
    List<String> getTexts() {
        return List.of("a", "b", "c");
    }

    @GetMapping("/numbers")
    Set<Integer> getNumbers() {
        return Set.of(1, 2, 3);
    }

    @GetMapping("/choices")
    Map<String, Boolean> getChoices() {
        Map<String, Boolean> choices = new HashMap<>();
        choices.put("do this", true);
        choices.put("do that", false);
        return choices;
    }
}
