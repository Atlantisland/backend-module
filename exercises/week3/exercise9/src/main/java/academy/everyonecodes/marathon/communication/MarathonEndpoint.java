package academy.everyonecodes.marathon.communication;

import academy.everyonecodes.marathon.domain.Runner;
import academy.everyonecodes.marathon.logic.MarathonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/runners")
public class MarathonEndpoint {

    private final MarathonService marathonService;

    public MarathonEndpoint(MarathonService marathonService) {
        this.marathonService = marathonService;
    }

    @PostMapping
    Runner post(@RequestBody Runner runner){
        marathonService.add(runner);
        return runner;
    }

    @GetMapping("/winner")
    Runner winner(){
        return marathonService.findWinner()
                .orElse(null);
    }
}
