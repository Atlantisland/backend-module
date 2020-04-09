package academy.everyonecodes.basket.communication.endpoints;

import academy.everyonecodes.basket.domain.Summary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/summaries")
public class SummaryEndpoint {

    private final List<Summary> summaries;

    public SummaryEndpoint(List<Summary> summaries) {
        this.summaries = summaries;
    }

    @GetMapping
    List<Summary> get() {
        return summaries;
    }
}
