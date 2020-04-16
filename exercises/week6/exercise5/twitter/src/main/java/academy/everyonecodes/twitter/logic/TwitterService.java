package academy.everyonecodes.twitter.logic;

import academy.everyonecodes.twitter.TweetRepository;
import academy.everyonecodes.twitter.domain.Tweet;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TwitterService {

    private final TweetRepository repository;

    public TwitterService(TweetRepository repository) {
        this.repository = repository;
    }

    public List<Tweet> findAllByTimestamp() {
        return repository.findAllByOrderByTimestampDesc();
    }

    public List<Tweet> findAllByUserByTimestamp(String user) {
        return repository.findAllByUserOrderByTimestampDesc(user);
    }

    public Tweet post(Tweet newTweet){
        newTweet.setComments(new ArrayList<>());
        newTweet.setTimestamp(LocalDateTime.now());
        repository.save(newTweet);
        return newTweet;
    }

    public void like(String id) {
        Optional<Tweet> oTweet = repository.findById(id);
        if (oTweet.isPresent()) {
            Tweet tweet = oTweet.get();
            tweet.setLikes(tweet.getLikes() + 1);
            repository.save(tweet);
        }
    }

    public void comment(String id, String comment) {
        Optional<Tweet> oToComment = repository.findById(id);
        if (oToComment.isPresent()) {
            Tweet tweet = oToComment.get();
            List<String> comments = tweet.getComments();
            comments.add(comment);
            repository.save(tweet);
        }
    }
}
