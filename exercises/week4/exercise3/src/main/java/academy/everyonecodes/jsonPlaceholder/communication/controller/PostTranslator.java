package academy.everyonecodes.jsonPlaceholder.communication.controller;

import academy.everyonecodes.jsonPlaceholder.domain.Post;
import academy.everyonecodes.jsonPlaceholder.domain.PostDTO;
import org.springframework.stereotype.Controller;

@Controller
public class PostTranslator {

    public PostDTO translateToDTO(Post post) {
        return new PostDTO(
                post.getIdentifier(),
                post.getUser(),
                post.getTitle(),
                post.getContent()
        );
    }

    public Post translateToPost(PostDTO postDTO) {
        return new Post(
                postDTO.getTitle(),
                postDTO.getBody(),
                postDTO.getUserId(),
                postDTO.getId()
        );
    }
}
