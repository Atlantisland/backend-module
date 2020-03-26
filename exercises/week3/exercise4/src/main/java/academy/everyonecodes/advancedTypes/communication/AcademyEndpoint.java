package academy.everyonecodes.advancedTypes.communication;

import academy.everyonecodes.advancedTypes.domain.Academy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/academies")
public class AcademyEndpoint {

    private final List<Academy> academies;

    public AcademyEndpoint(List<Academy> academies) {
        this.academies = academies;
    }

    @GetMapping
    List<Academy> getAcademies() {
        return academies;
    }
}
