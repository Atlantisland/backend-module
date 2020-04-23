package academy.everyoncecodes.socialNetwork.communication;

import academy.everyoncecodes.socialNetwork.logic.SocialNetworkService;
import academy.everyoncecodes.socialNetwork.persistence.domain.PersonDTO;
import academy.everyoncecodes.socialNetwork.persistence.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    PersonRepository repository;

    @MockBean
    SocialNetworkService service;

    private String url = "/persons";

    @Test
    void post() {
        PersonDTO personDTO = new PersonDTO("name");
        testRestTemplate.postForObject(url, personDTO, PersonDTO.class);
        verify(service).post(personDTO);
    }

    @Test
    void getAll() {
        testRestTemplate.getForObject(url, PersonDTO[].class);
        verify(service).getAll();
    }

    @Test
    void connect() {
        String connectUrl = url + "/" + 1 + "/friend" + 2;
        testRestTemplate.put(connectUrl, void.class);
        verify(service).connectById(1L, 2L);
    }

    @Test
    void disconnect() {
        String disconnectUrl = url + "/" + 1 + "/unfriend" + 2;
        testRestTemplate.put(disconnectUrl, void.class);
        verify(service).disconnectById(1L, 2L);
    }
}