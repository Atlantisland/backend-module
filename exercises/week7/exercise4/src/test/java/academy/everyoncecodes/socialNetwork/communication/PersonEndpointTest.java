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
        Long id1 = 123L;
        Long id2 = 321L;
        String connectUrl = url + "/" + id1 + "/friend/" + id2;
        testRestTemplate.put(connectUrl, null);
        verify(service).connectById(id1, id2);
    }

    @Test
    void disconnect() {
        Long id1 = 123L;
        Long id2 = 321L;
        String disconnectUrl = url + "/" + id1 + "/unfriend/" + id2;
        testRestTemplate.put(disconnectUrl, null);
        verify(service).disconnectById(id1, id2);
    }
}