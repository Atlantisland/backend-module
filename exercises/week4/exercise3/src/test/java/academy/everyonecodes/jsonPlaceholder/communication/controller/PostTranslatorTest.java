package academy.everyonecodes.jsonPlaceholder.communication.controller;

import academy.everyonecodes.jsonPlaceholder.domain.Post;
import academy.everyonecodes.jsonPlaceholder.domain.PostDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTranslatorTest {

    PostTranslator postTranslator = new PostTranslator();

    Post post = new Post("title", "connect", 1, 2);

    PostDTO postDTO = new PostDTO(2, 1, "title", "content");

    @Test
    void translateToDTO(){
        PostDTO result = postTranslator.translateToDTO(post);

        assertEquals(postDTO, result);
    }

    @Test
    void translateToPost(){
        Post result = postTranslator.translateToPost(postDTO);

        assertEquals(post, result);
    }
}