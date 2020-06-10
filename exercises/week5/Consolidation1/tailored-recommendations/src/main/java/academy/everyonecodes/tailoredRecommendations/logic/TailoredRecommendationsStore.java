package academy.everyonecodes.tailoredRecommendations.logic;

import academy.everyonecodes.tailoredRecommendations.domain.Movie;
import academy.everyonecodes.tailoredRecommendations.domain.TailoredRecommendation;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("recommendation")
public class TailoredRecommendationsStore {

    private List<TailoredRecommendation> tailoredRecommendations;

    void setTailoredRecommendations(List<TailoredRecommendation> tailoredRecommendations) {
        this.tailoredRecommendations = tailoredRecommendations;
    }

    List<TailoredRecommendation> getTailoredRecommendations() {
        return tailoredRecommendations;
    }

    public void post(TailoredRecommendation recommendation) {
        tailoredRecommendations.add(recommendation);
    }

    public List<Movie> getMovie(String uuid) {
        return tailoredRecommendations.stream()
                .filter(recommendation -> recommendation.getUserUuid().equals(uuid))
                .map(recommendation -> recommendation.getMovie())
                .collect(Collectors.toList());
    }
}
