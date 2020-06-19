package academy.everyonecodes.todos.logic;

import academy.everyonecodes.todos.domain.ToDo;
import academy.everyonecodes.todos.repository.ToDoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ToDoManagerTest {

    @Autowired
    ToDoManager manager;

    @MockBean
    ToDoRepository repository;

    @Test
    void save() {
        ToDo toDo = new ToDo("test");
        manager.save(toDo);
        verify(repository).save(toDo);
    }

    @Test
    void findAll() {
        manager.findAll();

        verify(repository).findAll();
    }

    @Test
    void findOne() {
        String id = "id";

        manager.findOne(id);

        verify(repository).findById(id);
    }

    @Test
   void markAsDoneDoesNotFindEntry(){
        String id = "id";
        Optional<ToDo> oExpected = Optional.empty();
        when(repository.findById(id)).thenReturn(oExpected);

        Optional<ToDo> oResult = manager.markAsDone(id);

        assertEquals(oExpected, oResult);
        verify(repository).findById(id);
    }

    @Test
    void markAsDoneFindsEntry(){
        String id = "id";
        Optional<ToDo> oExpected = Optional.of(new ToDo("test"));
        when(repository.findById(id)).thenReturn(oExpected);

        Optional<ToDo> oResult = manager.markAsDone(id);

        oExpected.get().setDone(true);
        assertEquals(oExpected, oResult);
        verify(repository).findById(id);
        verify(repository).save(oExpected.get());
    }

    @Test
    void deleteOne(){
        String id = "id";

        manager.delete(id);

        verify(repository).deleteById(id);
    }
}



