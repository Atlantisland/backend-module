package academy.everyoncecodes.socialNetwork.logic;

import academy.everyoncecodes.socialNetwork.persistence.domain.Person;
import academy.everyoncecodes.socialNetwork.persistence.domain.PersonDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonToPersonDtoTranslatorTest {

    PersonToPersonDtoTranslator translator = new PersonToPersonDtoTranslator();

    @Test
    void translateToDto() {
        Person person = new Person("name", List.of(new Person("friend1"), new Person("friend2")));

        PersonDTO result = translator.translateToDto(person);

        PersonDTO expected = new PersonDTO("name", List.of("friend1", "friend2"));
        assertEquals(expected, result);
    }

    @Test
    void translateToEntity() {
        PersonDTO personDTO = new PersonDTO("name");

        Person result = translator.translateToEntity(personDTO);

        Person expected = new Person("name");
        assertEquals(expected, result);
    }
}