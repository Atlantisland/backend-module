package academy.everyonecodes.twitter.logic;

import academy.everyonecodes.twitter.TweetRepository;
import academy.everyonecodes.twitter.domain.Tweet;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TwitterServiceTest {

    @Autowired
    TwitterService service;

    @MockBean
    TweetRepository repository;

    @Test
    void post() {
        Tweet test = new Tweet("user", "text", 1, List.of("comment", "comment"), LocalDateTime.now());
        assertNull(test.getId());
        service.post(test);
        Mockito.verify(repository).save(test);
    }

    @Test
    void findAllStartingFromLatest() {
        service.findAllByTimestamp();
        Mockito.verify(repository).findAllByOrderByTimestampDesc();
    }

    @Test
    void findAllByUserStartingFromLatest() {
        String user = "user";
        service.findAllByUserByTimestamp(user);
        Mockito.verify(repository).findAllByUserOrderByTimestampDesc(user);
    }

    @Test
    void like() {
        String id = "id";
        Tweet tweet1 = new Tweet("user", "text", 3, List.of("comment"), LocalDateTime.now());
        when(repository.findById(id)).thenReturn(java.util.Optional.of(tweet1));
        service.like(id);
        Mockito.verify(repository).save(tweet1);
    }

    @Test
    void comment() {
        String id = "id";
        String comment = "comment";
        Tweet tweet1 = new Tweet("user", "text", 3, List.of("comment"), LocalDateTime.now());
        when(repository.findById(id)).thenReturn(java.util.Optional.of(tweet1));
        service.comment(id, comment);
        Mockito.verify(repository).save(tweet1);
    }
}
