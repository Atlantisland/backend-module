package academy.everyonecodes.logic;

import academy.everyonecodes.communication.client.HotRightnowClient;
import academy.everyonecodes.communication.client.TailoredRecommendationsClient;
import academy.everyonecodes.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    private final TailoredRecommendationsClient tailoredRecommendationsClient;
    private final HotRightnowClient hotRightNowClient;

    public RecommendationService(TailoredRecommendationsClient tailoredRecommendationsClient, HotRightnowClient hotRightNowClient) {
        this.tailoredRecommendationsClient = tailoredRecommendationsClient;
        this.hotRightNowClient = hotRightNowClient;
    }

    public List<Movie> getMovieByUuid(String uuid) {
        List<Movie> tailoredMovies = tailoredRecommendationsClient.getTailoredRecommendations(uuid);
        return tailoredMovies.size() > 0 ? tailoredMovies : hotRightNowClient.getRecommendations(uuid);
    }
}
