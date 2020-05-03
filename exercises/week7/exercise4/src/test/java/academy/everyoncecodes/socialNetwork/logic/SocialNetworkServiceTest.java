package academy.everyoncecodes.socialNetwork.logic;

import academy.everyoncecodes.socialNetwork.persistence.domain.Person;
import academy.everyoncecodes.socialNetwork.persistence.domain.PersonDTO;
import academy.everyoncecodes.socialNetwork.persistence.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SocialNetworkServiceTest {

    @Autowired
    SocialNetworkService service;

    @MockBean
    PersonRepository repository;

    @MockBean
    PersonToPersonDtoTranslator translator;

    static Stream<Arguments> parameters() {
        return Stream.of(
                of(Optional.empty(), Optional.empty()),
                of(Optional.empty(), Optional.of(new Person("name"))),
                of(Optional.of(new Person("name")), Optional.empty())
        );
    }

    @Test
    void findAll() {
        Person person1 = new Person("name1");
        Person person2 = new Person("name2");
        when(repository.findAll())
                .thenReturn(List.of(person1, person2));

        service.getAll();

        verify(repository).findAll();
        verify(translator).translateToDto(person1);
        verify(translator).translateToDto(person2);
    }

    @Test
    void save() {
        PersonDTO personDTO = new PersonDTO("name");
        Person person = new Person("name");
        when(translator.translateToEntity(personDTO))
                .thenReturn(person);

        service.post(personDTO);

        verify(translator).translateToEntity(personDTO);
        verify(repository).save(person);
        verify(translator).translateToDto(person);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void friendDoesNotFindBothPersons(Optional<Person> oPerson1, Optional<Person> oPerson2) {
        Long id1 = 123L;
        Long id2 = 321L;
        when(repository.findById(id1))
                .thenReturn(oPerson1);
        when(repository.findById(id2))
                .thenReturn(oPerson2);

        service.connectById(id1, id2);

        verify(repository).findById(id1);
        verify(repository).findById(id2);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void friendFindsBothPersons() {
        Long id1 = 123L;
        Long id2 = 321L;
        Person person1 = new Person("name1");
        Person person2 = new Person("name2");
        when(repository.findById(id1))
                .thenReturn(Optional.of(person1));
        when(repository.findById(id2))
                .thenReturn(Optional.of(person2));

        service.connectById(id1, id2);

        verify(repository).findById(id1);
        verify(repository).findById(id2);
        verify(repository).save(new Person("name1", List.of(person2)));
        verify(repository).save(new Person("name2", List.of(person1)));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void unfriendDoesNotFindBothPersons(Optional<Person> oPerson1, Optional<Person> oPerson2) {
        Long id1 = 123L;
        Long id2 = 321L;
        when(repository.findById(id1))
                .thenReturn(oPerson1);
        when(repository.findById(id2))
                .thenReturn(oPerson2);

        service.disconnectById(id1, id2);

        verify(repository).findById(id1);
        verify(repository).findById(id2);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void unfriendFindsBothPersons() {
        Long id1 = 123L;
        Long id2 = 321L;
        Person person1 = new Person(id1, "name1", new ArrayList<>(List.of(new Person(id2, "name2"))));
        Person person2 = new Person(id2, "name2", new ArrayList<>(List.of(new Person(id1, "name1"))));
        when(repository.findById(id1))
                .thenReturn(Optional.of(person1));
        when(repository.findById(id2))
                .thenReturn(Optional.of(person2));

        service.disconnectById(id1, id2);

        verify(repository).findById(id1);
        verify(repository).findById(id2);
        verify(repository).save(new Person(id1, "name1", List.of()));
        verify(repository).save(new Person(id2, "name2", List.of()));
    }
}
