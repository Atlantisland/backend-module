package academy.everyonecodes.developerSkills.logic;

import academy.everyonecodes.developerSkills.domain.Developer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@ConfigurationProperties("skills")
public class DeveloperService {

    private List<Developer> developers;

    public List<Developer> findAll(){
        return developers;
    }

    public List<Developer> findBy(String skills){
        List<String> individualSkills = List.of(skills.split(" "));
        return developers.stream()
                .filter(developer -> developer.getSkills().containsAll(individualSkills))
                .collect(toList());
    }

    void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }
}
