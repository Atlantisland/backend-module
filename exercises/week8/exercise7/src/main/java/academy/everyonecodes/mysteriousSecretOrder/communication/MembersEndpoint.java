package academy.everyonecodes.mysteriousSecretOrder.communication;

import academy.everyonecodes.mysteriousSecretOrder.logic.MessageService;
import academy.everyonecodes.mysteriousSecretOrder.persistence.domain.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MembersEndpoint {

    private final MessageService messageService;

    public MembersEndpoint(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    @Secured("ROLE_MASTER")
    User post(@RequestBody User user) {
        messageService.save(user);
        return user;
    }

    @GetMapping
    @Secured("ROLE_MASTER")
    List<User> get() {
        return messageService.findAll();
    }

    @GetMapping("/apprentices")
    @Secured({"ROLE_APPRENTICE", "ROLE_MASTER"})
    List<User> getApprentices() {
        return messageService.findApprentices();
    }
}