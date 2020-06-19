package academy.everyonecodes.todos.communication;

import academy.everyonecodes.todos.domain.ToDo;
import academy.everyonecodes.todos.logic.ToDoManager;
import academy.everyonecodes.todos.repository.ToDoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ToDosEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    ToDoRepository repository;

    @MockBean
    ToDoManager manager;

    String url = "/todos";


    @Test
    void getAll() {
        restTemplate.getForObject(url, ToDo[].class);
        verify(manager).findAll();
    }

    @Test
    void getOne() {
        String id = "id";
        restTemplate.getForObject(url + "/" + id, ToDo.class);
        verify(manager).findOne(id);
    }

    @Test
    void post() {
        ToDo test = new ToDo("toCook");
        restTemplate.postForObject(url, test, ToDo.class);
        verify(manager).save(test);
    }

    @Test
    void put() {
        String id = "id";
        String done = "/done";
        restTemplate.put(url + "/" + id + done, null);
        verify(manager).markAsDone(id);
    }

    @Test
    void delete() {
        String id = "id";
        restTemplate.delete(url + "/" + id);
        verify(manager).delete(id);
    }
}



