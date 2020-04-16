package academy.everyonecodes.communication.endpoint;

import academy.everyonecodes.domain.Movie;
import academy.everyonecodes.logic.RecommendationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/recommendations")
public class RecommendationEndpoint {

    private final RecommendationService service;

    public RecommendationEndpoint(RecommendationService service) {
        this.service = service;
    }

    @GetMapping("/{userUuid}")
    Set<Movie> get(@PathVariable String userUuid){
        return service.getMovieByUuid(userUuid);
    }
}
