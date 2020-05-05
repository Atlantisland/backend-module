package academy.everyonecodes.validation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ArtworksEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    TextService service;

    String url ="/artworks";

    @Test
    void post(){
        Rating rating = new Rating(2);
        Artwork artwork = new Artwork("name", rating);

        testRestTemplate.postForObject(url, artwork, Artwork.class);

        verify(service).returnSameText(artwork.getName());

    }

}

// I think that I should have created a repository class as well and to use it here...but no I am running out of time now
// So I just let it like this