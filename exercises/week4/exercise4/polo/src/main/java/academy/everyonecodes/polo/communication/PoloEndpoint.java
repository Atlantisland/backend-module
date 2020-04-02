package academy.everyonecodes.polo.communication;

import academy.everyonecodes.polo.logic.Polo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polo")
public class PoloEndpoint {

    private final Polo polo;

    public PoloEndpoint(Polo polo) {
        this.polo = polo;
    }

    @PostMapping("/{message}")
    String post(@PathVariable String message){
        return polo.giveResponse(message);
    }
}
