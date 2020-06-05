package academy.everyonecodes.jsonPlaceholder.communication.client;

import academy.everyonecodes.jsonPlaceholder.communication.controller.PostTranslator;
import academy.everyonecodes.jsonPlaceholder.domain.Post;
import academy.everyonecodes.jsonPlaceholder.domain.PostDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class JsonPlaceholderClient {

    private final PostTranslator postTranslator;
    private final RestTemplate restTemplate;
    private final String url;


    public JsonPlaceholderClient(PostTranslator postTranslator, RestTemplate restTemplate, @Value("${jsonplaceholder.posts.url}") String url) {
        this.postTranslator = postTranslator;
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public List<Post> getAll() {
        PostDTO[] dtos = restTemplate.getForObject(url, PostDTO[].class);
        return Stream.of(dtos)
                .map(postTranslator::translateToPost)
                .collect(Collectors.toList());
    }

    public Post getOne(int id) {
        PostDTO dto = restTemplate.getForObject(url + "/" + id, PostDTO.class);
        return postTranslator.translateToPost(dto);
    }

    public Post post(Post post) {
        PostDTO requestDTO = postTranslator.translateToDTO(post);
        PostDTO responseDTO = restTemplate.postForObject(url, requestDTO, PostDTO.class);
        return postTranslator.translateToPost(responseDTO);
    }

    public Post put(int id, Post post) {
        PostDTO requestDTO = postTranslator.translateToDTO(post);
        restTemplate.put(url + "/" + id, requestDTO);
        return post;
    }

    public void delete(int id) {
        restTemplate.delete(url + "/" + id);
    }
}
