package academy.everyonecodes.twitter.communication;

import academy.everyonecodes.twitter.TweetRepository;
import academy.everyonecodes.twitter.domain.Tweet;
import academy.everyonecodes.twitter.logic.TwitterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TweetsEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    TweetRepository repository;

    @MockBean
    TwitterService service;

    String url = "/tweets";

    @Test
    void getAll() {
        restTemplate.getForObject(url, Tweet[].class);
        verify(service).findAllByTimestamp();
    }

    @Test
    void getTest() {
        String user = "user";
        restTemplate.getForObject(url + "/user/" + user, Tweet[].class);
        verify(service).findAllByUserByTimestamp(user);
    }

    @Test
    void postTest() {
        Tweet test = new Tweet("user", "text");
        restTemplate.postForObject(url, test, Tweet.class);
        verify(service).post(test);
    }

    @Test
    void like() {
        String id = "id";

        restTemplate.put(url + "/" + id + "/likes", null);

        verify(service).like(id);
    }

    @Test
    void comment() {
        String id = "id";
        String comment = "comment";

        restTemplate.put(url + "/" + id + "/comments", comment);

        verify(service).comment(id, comment);
    }

}