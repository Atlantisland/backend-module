package academy.everyoncecodes.socialNetwork.logic;

import academy.everyoncecodes.socialNetwork.persistence.domain.Person;
import academy.everyoncecodes.socialNetwork.persistence.domain.PersonDTO;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;

@Service
public class PersonToPersonDtoTranslator {

    public PersonDTO translateToDto(Person person) {
        return new PersonDTO(
                person.getId(),
                person.getName(),
                person.getFriends().stream()
                        .map(Person::getName)
                        .collect(toList())
        );
    }

    public Person translateToEntity(PersonDTO personDTO) {
        return new Person(personDTO.getName());
    }
}

