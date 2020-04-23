package academy.everyoncecodes.socialNetwork.logic;

import academy.everyoncecodes.socialNetwork.persistence.domain.Person;
import academy.everyoncecodes.socialNetwork.persistence.domain.PersonDTO;
import academy.everyoncecodes.socialNetwork.persistence.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SocialNetworkServiceTest {

    @Autowired
    SocialNetworkService service;

    @MockBean
    PersonRepository repository;

    @Test
    void post(){
        PersonDTO personDTO = new PersonDTO(1L, "name", List.of("name1", "name2"));
        Person person = service.translateIntoPerson(personDTO);
        verify(repository).save(person);
    }

    @Test
    void getAll(){
        service.getAll();
        verify(repository).findAll();
    }

    @Test
    void connectById(){
        Long id1 = 1L;
        Long id2 = 2L;
        service.connectById(id1,id2);
        verify(repository).findById(id1);
        verify(repository).findById(id2);
    }

    @Test
    void disconnectById(){
        Long id1 = 1L;
        Long id2 = 2L;
        service.disconnectById(id1,id2);
        verify(repository).findById(id1);
        verify(repository).findById(id2);
    }
}