package academy.everyonecodes.developerSkills.communication;

import academy.everyonecodes.developerSkills.domain.Developer;
import academy.everyonecodes.developerSkills.logic.DeveloperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/developers")
public class DeveloperEndpoint {

    private final DeveloperService developerService;

    public DeveloperEndpoint(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping
    List<Developer> findAll(){
        return developerService.findAll();
    }

    @GetMapping("/skills/{skills}")
    List<Developer> findBySkills(@PathVariable String skills){
        return developerService.findBy(skills);
    }
}
