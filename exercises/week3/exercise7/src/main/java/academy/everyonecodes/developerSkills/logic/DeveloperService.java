package academy.everyonecodes.developerSkills.logic;

import academy.everyonecodes.developerSkills.domain.Developer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("skills")
public class DeveloperService {

    private List<Developer> developers;

    void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public List<Developer> finaAll() {
        return developers;
    }

    public List<Developer> findBy(String requestedSkills) {
        Set<String> skills = Set.of(requestedSkills.split(" "));
        return developers.stream()
                .filter(developer -> developer.getSkills().containsAll(skills))
                .collect(Collectors.toList());
    }
}



