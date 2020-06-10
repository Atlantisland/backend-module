package academy.everyonecodes.communication.client;

import academy.everyonecodes.domain.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TailoredRecommendationsClientTest {

    @Autowired
    TailoredRecommendationsClient tailoredRecommendationsClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${recommendations.urls.tailored-recommendations}")
    String url;

    @Test
    void getRecommendations() {
        String userUuid = "userUuid";
        String oneUserUrl = url + "/" + userUuid;
        when(restTemplate.getForObject(oneUserUrl, Movie[].class))
                .thenReturn(new Movie[]{});

        tailoredRecommendationsClient.getTailoredRecommendations(userUuid);

        verify(restTemplate).getForObject(oneUserUrl, Movie[].class);
    }
}
