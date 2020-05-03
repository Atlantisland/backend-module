package academy.everyoncecodes.socialNetwork.logic;

import academy.everyoncecodes.socialNetwork.persistence.domain.Person;
import academy.everyoncecodes.socialNetwork.persistence.domain.PersonDTO;
import academy.everyoncecodes.socialNetwork.persistence.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SocialNetworkService {

    private final PersonRepository repository;
    private final PersonToPersonDtoTranslator translator;

    public SocialNetworkService(PersonRepository repository, PersonToPersonDtoTranslator translator) {
        this.repository = repository;
        this.translator = translator;
    }

    public PersonDTO post(PersonDTO personDTO) {
        Person person = translator.translateToEntity(personDTO);
        repository.save(person);
        return translator.translateToDto(person);
    }

    public List<PersonDTO> getAll() {
        List<Person> friends = repository.findAll();
        return friends.stream()
                .map(translator::translateToDto)
                .collect(Collectors.toList());
    }

    public void connectById(Long id1, Long id2) {
        Optional<Person> oPerson1 = repository.findById(id1);
        Optional<Person> oPerson2 = repository.findById(id2);
        if (oPerson1.isEmpty() || oPerson2.isEmpty()) {
            return;
        }
        Person person1 = oPerson1.get();
        Person person2 = oPerson2.get();
        person1.getFriends().add(person2);
        person2.getFriends().add(person1);
        repository.save(person1);
        repository.save(person2);
    }

    public void disconnectById(Long id1, Long id2) {
        Optional<Person> oPerson1 = repository.findById(id1);
        Optional<Person> oPerson2 = repository.findById(id2);
        if (oPerson1.isEmpty() || oPerson2.isEmpty()) {
            return;
        }
        Person person1 = oPerson1.get();
        Person person2 = oPerson2.get();
        person1.getFriends().remove(person2);
        person2.getFriends().remove(person1);
        repository.save(person1);
        repository.save(person2);
    }
}

