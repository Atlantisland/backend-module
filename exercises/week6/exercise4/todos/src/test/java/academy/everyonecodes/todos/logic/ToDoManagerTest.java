package academy.everyonecodes.todos.logic;

import academy.everyonecodes.todos.domain.ToDo;
import academy.everyonecodes.todos.repository.ToDoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ToDoManagerTest {

    @Autowired
    ToDoManager manager;

    @MockBean
    ToDoRepository repository;

    @Test
    void save() {
        ToDo test1 = new ToDo("toCook", true);
        assertNull(test1.getId());
        manager.save(test1);

        Mockito.verify(repository).save(test1);
    }

    @Test
    void findAll() {
        manager.findAll();

        Mockito.verify(repository).findAll();
    }

    @Test
    void findByID() {
        String id = "test id";

        manager.findById(id);

        Mockito.verify(repository).findById(id);
    }

    @Test
    void beDone() {
        String id = "id";
        ToDo test2 = new ToDo("toCook", false);
        when(repository.findById(id)).thenReturn(java.util.Optional.of(test2));

        manager.beDone(id);
        Mockito.verify(repository).save(test2);
    }
}



