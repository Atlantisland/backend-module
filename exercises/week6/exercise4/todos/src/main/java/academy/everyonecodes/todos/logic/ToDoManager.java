package academy.everyonecodes.todos.logic;

import academy.everyonecodes.todos.domain.ToDo;
import academy.everyonecodes.todos.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoManager {

    private final ToDoRepository repository;

    public ToDoManager(ToDoRepository repository) {
        this.repository = repository;
    }

    public ToDo save(ToDo toDo) {
        return repository.save(toDo);
    }

    public List<ToDo> findAll() {
        List<ToDo> todos = repository.findAll();
        System.out.println(todos);
        return todos;
    }

    public Optional<ToDo> findOne(String id) {

        return repository.findById(id);
    }

    public Optional<ToDo> markAsDone(String id) {
        Optional<ToDo> oToDo = repository.findById(id);
        if(oToDo.isEmpty()){
            return Optional.empty();
        }
        ToDo toDo = oToDo.get();
        toDo.setDone(true);
        repository.save(toDo);
        return Optional.of(toDo);
    }

    public void delete(String id) {

        repository.deleteById(id);
    }
}
