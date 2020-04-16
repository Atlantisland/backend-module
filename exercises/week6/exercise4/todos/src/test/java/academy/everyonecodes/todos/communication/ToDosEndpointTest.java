package academy.everyonecodes.todos.communication;

import academy.everyonecodes.todos.domain.ToDo;
import academy.everyonecodes.todos.logic.ToDoManager;
import academy.everyonecodes.todos.repository.ToDoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
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
    void getTest() {
        String id = "id";
        restTemplate.getForObject(url + "/" + id, ToDo.class);
        verify(manager).findById(id);
    }

    @Test
    void postTest() {
        ToDo test = new ToDo("toCook", true);
        restTemplate.postForObject(url, test, ToDo.class);
        verify(manager).save(test);
    }

    @Test
    void putTest() {
        String id = "id";
        String done = "done";
        Optional<ToDo> test = manager.beDone(id);
        restTemplate.put(url + "/" + id + done, test);
        verify(manager).beDone(anyString());
    }

    @Test
    void delete() {
        String id = "id";
        restTemplate.delete(url + "/" + id);
        verify(manager).deleteItemById(anyString());
    }
}



