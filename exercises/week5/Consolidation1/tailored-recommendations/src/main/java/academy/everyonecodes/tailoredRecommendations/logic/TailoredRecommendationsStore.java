package academy.everyonecodes.tailoredRecommendations.logic;

import academy.everyonecodes.tailoredRecommendations.domain.Movie;
import academy.everyonecodes.tailoredRecommendations.domain.TailoredRecommendation;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("recommendation")
public class TailoredRecommendationsStore {

    private Set<TailoredRecommendation> tailoredRecommendations;


    void setTailoredRecommendations(Set<TailoredRecommendation> tailoredRecommendations) {
        this.tailoredRecommendations = tailoredRecommendations;

    }

    Set<TailoredRecommendation> getTailoredRecommendations() {
        return tailoredRecommendations;
    }

    public TailoredRecommendation post(TailoredRecommendation recommendation) {
        tailoredRecommendations.add(recommendation);
        return recommendation;
    }

    public Set<Movie> getMovie(String uuid) {
        return tailoredRecommendations.stream()
                .filter(recommendation -> recommendation.getUserUuid().equals(uuid))
                .map(recommendation -> recommendation.getMovie())
                .collect(Collectors.toSet());
    }
}
