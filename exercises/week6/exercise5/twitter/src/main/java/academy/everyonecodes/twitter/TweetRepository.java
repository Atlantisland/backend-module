package academy.everyonecodes.twitter;

import academy.everyonecodes.twitter.domain.Tweet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TweetRepository extends MongoRepository<Tweet, String> {

    List<Tweet> findAllByOrderByTimestampDesc();

    List<Tweet> findAllByUserOrderByTimestampDesc(String user);

}

