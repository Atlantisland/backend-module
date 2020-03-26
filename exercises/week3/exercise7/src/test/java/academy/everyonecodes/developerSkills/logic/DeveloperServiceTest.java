package academy.everyonecodes.developerSkills.logic;

import academy.everyonecodes.developerSkills.domain.Developer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeveloperServiceTest {

    @Autowired
    DeveloperService service;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(
                        new Developer("developer1", Set.of("skill1", "skill2", "skill3")),
                        new Developer("developer2", Set.of("skill1", "skill3"))), "skill1 skill3"),
                Arguments.of(List.of(new Developer("developer3", Set.of("skill4"))), "skill4"),
                Arguments.of(List.of(), "skill5")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findBy(List<Developer> expected, String skill) {
        List<Developer> result = service.findBy(skill);

        assertEquals(expected, result);
    }
}

