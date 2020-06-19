package academy.everyonecodes.twitter.logic;

import academy.everyonecodes.twitter.TweetRepository;
import academy.everyonecodes.twitter.domain.Tweet;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TwitterServiceTest {

    @Autowired
    TwitterService service;

    @MockBean
    TweetRepository repository;

    @Test
    void post() {
        Tweet test = new Tweet("user", "text");
        assertNull(test.getComments());
        assertNull(test.getTimestamp());

        service.post(test);

        assertNotNull(test.getComments());
        assertTrue(test.getComments().isEmpty());
        assertNotNull(test.getTimestamp());
        verify(repository).save(test);
    }

    @Test
    void findAllStartingFromLatest() {
        service.findAllByTimestamp();
        verify(repository).findAllByOrderByTimestampDesc();
    }

    @Test
    void findAllByUserStartingFromLatest() {
        String user = "user";
        service.findAllByUserByTimestamp(user);
        verify(repository).findAllByUserOrderByTimestampDesc(user);
    }

    @Test
    void likeFindsTweet() {
        String id = "id";
        Tweet tweet1 = new Tweet("user", "text");
        assertEquals(0, tweet1.getLikes());
        when(repository.findById(id)).thenReturn(Optional.of(tweet1));

        service.like(id);

        assertEquals(1, tweet1.getLikes());
        verify(repository).findById(id);
        verify(repository).save(tweet1);
    }

    @Test
    void likeDoesNotFindTweet(){
      String id = "id";
      when(repository.findById(id)).thenReturn(Optional.empty());

      service.like(id);

      verify(repository).findById(id);
      verify(repository, never()).save(any(Tweet.class));
    }

    @Test
    void commentFindsTweet() {
        String id = "id";
        String comment = "comment";
        Tweet tweet1 = new Tweet("user", "text", new ArrayList<>());
        assertNotNull(tweet1.getComments());
        assertTrue(tweet1.getComments().isEmpty());
        when(repository.findById(id)).thenReturn(Optional.of(tweet1));

        service.comment(id, comment);

        assertEquals(1, tweet1.getComments().size());
        assertEquals(comment, tweet1.getComments().get(0));
        verify(repository).findById(id);
        verify(repository).save(tweet1);
    }

    @Test
    void commentDoesNotFindTweet(){
        String id = "id";
        String comment = "comment";
        when(repository.findById(id)).thenReturn(Optional.empty());

        service.comment(id, comment);

        verify(repository).findById(id);
        verify(repository, never()).save(any(Tweet.class));
    }
}
