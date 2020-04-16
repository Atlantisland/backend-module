package academy.everyonecodes.todos.repository;

import academy.everyonecodes.todos.domain.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository extends MongoRepository<ToDo, String> {

}