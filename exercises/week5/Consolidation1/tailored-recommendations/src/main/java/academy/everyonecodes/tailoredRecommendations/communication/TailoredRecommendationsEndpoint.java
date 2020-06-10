package academy.everyonecodes.tailoredRecommendations.communication;

import academy.everyonecodes.tailoredRecommendations.domain.Movie;
import academy.everyonecodes.tailoredRecommendations.domain.TailoredRecommendation;
import academy.everyonecodes.tailoredRecommendations.logic.TailoredRecommendationsStore;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tailoredrecommendations")
public class TailoredRecommendationsEndpoint {

    private final TailoredRecommendationsStore tailoredRecommendationsStore;

    public TailoredRecommendationsEndpoint(TailoredRecommendationsStore tailoredRecommendationsStore) {
        this.tailoredRecommendationsStore = tailoredRecommendationsStore;
    }

    @GetMapping("/{userUuid}")
    List<Movie> get (@PathVariable String userUuid) {
        return tailoredRecommendationsStore.getMovie(userUuid);
    }

    @PostMapping
    TailoredRecommendation post(@RequestBody TailoredRecommendation tailoredRecommendation) {
        tailoredRecommendationsStore.post(tailoredRecommendation);
        return tailoredRecommendation;
    }
}
