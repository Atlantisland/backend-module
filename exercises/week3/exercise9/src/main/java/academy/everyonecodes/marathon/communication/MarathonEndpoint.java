package academy.everyonecodes.marathon.communication;

import academy.everyonecodes.marathon.domain.Runner;
import academy.everyonecodes.marathon.logic.MarathonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/runners")
public class MarathonEndpoint {

    private final MarathonService service;

    public MarathonEndpoint(MarathonService service) {
        this.service = service;
    }

    @PostMapping
    Runner post(@RequestBody Runner runner) {
        service.add(runner);
        return runner;
    }

    @GetMapping("/winner")
    Runner getWinner() {
        return service.findWinner().orElse(null);
    }
}
