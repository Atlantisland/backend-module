package academy.everyoncecodes.socialNetwork.logic;

import academy.everyoncecodes.socialNetwork.persistence.domain.Person;
import academy.everyoncecodes.socialNetwork.persistence.domain.PersonDTO;
import academy.everyoncecodes.socialNetwork.persistence.repository.PersonRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SocialNetworkService {

    private final PersonRepository repository;

    public SocialNetworkService(PersonRepository repository) {
        this.repository = repository;
    }

    public PersonDTO post(PersonDTO personDTO){
        Person person = translateIntoPerson(personDTO);
        repository.save(person);
        return translateIntoPersonDTO(person);
    }

    public Person translateIntoPerson(PersonDTO personDTO){
        return new Person(personDTO.getName(), new ArrayList<>());
    }

    public PersonDTO translateIntoPersonDTO(Person person){
        return new PersonDTO(
                person.getId(),
                person.getName(),
                person.getFriends()
                    .stream()
                    .map(Person::getName)
                .collect(Collectors.toList())
                );
    }

    public List<PersonDTO> getAll(){
        List<Person> friends = repository.findAll();
        return friends.stream()
                .map(friend->translateIntoPersonDTO(friend))
                .collect(Collectors.toList());
    }

    public void connectById(Long id1, Long id2){
        Optional<Person> person1 = repository.findById(id1);
        Optional<Person> person2 = repository.findById(id2);
        if(person1.isPresent() && person2.isPresent()){
            connect(person1.get(), person2.get());
            connect(person2.get(), person1.get());
        }
    }

    public void connect(Person person1, Person person2){
        List<Person> friends = person1.getFriends();
        if(!friends.contains(person2)){
            friends.add(person2);
            repository.save(person1);
        }
    }

    public void disconnectById(Long id1, Long id2){
        Optional<Person> person1 = repository.findById(id1);
        Optional<Person> person2 = repository.findById(id2);

        if(person1.isPresent() && person2.isPresent()){
            disconnect(person1.get(), person2.get());
            disconnect(person2.get(), person1.get());
        }
    }

    public void disconnect(Person person1, Person person2){
        List<Person> friends = person1.getFriends();
        if(!friends.contains(person2)){
            friends.remove(person2);
            repository.save(person1);
        }
    }
}
