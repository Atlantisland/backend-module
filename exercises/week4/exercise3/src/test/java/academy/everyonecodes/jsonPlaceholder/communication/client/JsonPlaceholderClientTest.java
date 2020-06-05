package academy.everyonecodes.jsonPlaceholder.communication.client;

import academy.everyonecodes.jsonPlaceholder.communication.controller.PostTranslator;
import academy.everyonecodes.jsonPlaceholder.domain.Post;
import academy.everyonecodes.jsonPlaceholder.domain.PostDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class JsonPlaceholderClientTest {

    @Autowired
    JsonPlaceholderClient jsonPlaceholderClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${jsonplaceholder.posts.url}")
    String url;

    @SpyBean
    PostTranslator postTranslator;

    Post post = new Post("title", "content", 1, 2);

    PostDTO postDTO = new PostDTO(2, 1, "title", "content");

    @Test
    void getAll() {
        when(restTemplate.getForObject(url, PostDTO[].class))
                .thenReturn(new PostDTO[]{postDTO, postDTO});

        jsonPlaceholderClient.getAll();

        verify(restTemplate).getForObject(url, PostDTO[].class);
        verify(postTranslator, times(2)).translateToPost(postDTO);
    }

    @Test
    void getOne() {
        int id = 0;
        String getOneUrl = url + "/" + id;
        when(restTemplate.getForObject(getOneUrl, PostDTO.class))
                .thenReturn(postDTO);

        jsonPlaceholderClient.getOne(id);

        verify(restTemplate).getForObject(getOneUrl, PostDTO.class);
        verify(postTranslator).translateToPost(postDTO);
    }

    @Test
    void post() {
        when(restTemplate.postForObject(url, postDTO, PostDTO.class))
                .thenReturn(postDTO);

        jsonPlaceholderClient.post(post);

        verify(restTemplate).postForObject(url, postDTO, PostDTO.class);
        verify(postTranslator).translateToDTO(post);
        verify(postTranslator).translateToPost(postDTO);
    }

    @Test
    void put() {
        int id = 0;

        jsonPlaceholderClient.put(id, post);

        verify(restTemplate).put(url + "/" + id, postDTO);
        verify(postTranslator).translateToDTO(post);
    }

    @Test
    void deleteOne() {
        int id = 1;

        jsonPlaceholderClient.delete(id);

        verify(restTemplate).delete(url + "/" + id);
    }
}