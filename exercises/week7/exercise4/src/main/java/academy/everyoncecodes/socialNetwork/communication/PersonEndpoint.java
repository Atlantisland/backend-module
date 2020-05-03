package academy.everyoncecodes.socialNetwork.communication;

import academy.everyoncecodes.socialNetwork.logic.SocialNetworkService;
import academy.everyoncecodes.socialNetwork.persistence.domain.PersonDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonEndpoint {

    private final SocialNetworkService service;

    public PersonEndpoint(SocialNetworkService service) {
        this.service = service;
    }

    @PostMapping
    PersonDTO post(@Valid @RequestBody PersonDTO personDTO){
        return service.post(personDTO);
    }

    @GetMapping
    List<PersonDTO> getAll(){
        return service.getAll();
    }

    @PutMapping("/{id1}/friend/{id2}")
        void connect(@PathVariable long id1, @PathVariable long id2){
            service.connectById(id1, id2);
        }

    @PutMapping("/{id1}/unfriend/{id2}")
        void disconnect(@PathVariable long id1, @PathVariable long id2){
            service.disconnectById(id1, id2);
        }
}
