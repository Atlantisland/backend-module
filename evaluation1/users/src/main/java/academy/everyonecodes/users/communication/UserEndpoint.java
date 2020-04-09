package academy.everyonecodes.users.communication;

import academy.everyonecodes.users.domain.User;
import academy.everyonecodes.users.logic.UserStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserEndpoint {

    private final UserStore store;


    public UserEndpoint(UserStore store) {
        this.store = store;
    }

    @GetMapping("/{email}")
    User get(@PathVariable String email){
        return store.getUserByEmail(email)
        .orElse(null);
    }
}
