package academy.everyonecodes.twitter.communication;

import academy.everyonecodes.twitter.domain.Tweet;
import academy.everyonecodes.twitter.logic.TwitterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TweetsEndpoint {

    private final TwitterService service;

    public TweetsEndpoint(TwitterService service) {
        this.service = service;
    }

    @GetMapping
    List<Tweet> getAllByTime() {
        return service.findAllByTimestamp();
    }

    @GetMapping("/user/{user}")
    List<Tweet> getAllByTime(@PathVariable String user) {

        return service.findAllByUserByTimestamp(user);
    }

    @PostMapping
    Tweet post(@RequestBody Tweet tweet) {

        return service.post(tweet);
    }

    @PutMapping("/{id}/likes")
    void like(@PathVariable String id) {
        service.like(id);
    }

    @PutMapping("/{id}/comments")
    void comment(@PathVariable String id, @RequestBody String comment) {

        service.comment(id, comment);
    }
}
