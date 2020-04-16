package academy.everyonecodes.todos.communication;

import academy.everyonecodes.todos.domain.ToDo;
import academy.everyonecodes.todos.logic.ToDoManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDosEndpoint {

    private final ToDoManager manager;

    public ToDosEndpoint(ToDoManager manager) {
        this.manager = manager;
    }

    @GetMapping
    List<ToDo> get() {
        return manager.findAll();
    }

    @GetMapping("/{id}")
    ToDo get(@PathVariable String id) {
        return manager.findById(id).orElse(null);
    }

    @PostMapping
    ToDo post(@RequestBody ToDo todo) {
        return manager.save(todo);
    }

    @PutMapping("/{id}/done")
    ToDo put(@PathVariable String id) {
        ToDo beDone = get(id);
        manager.beDone(id);
        return manager.save(beDone);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        manager.deleteItemById(id);
    }
}
