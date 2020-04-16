package academy.everyonecodes.developerSkills.logic;

import academy.everyonecodes.developerSkills.domain.Developer;
import org.junit.jupiter.api.Test;
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
    DeveloperService developerService;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(), ""),
                Arguments.of(List.of(), "unskill"),
                Arguments.of(List.of(
                        new Developer("name2", Set.of("skill2", "skill3"))), "skill2"),
                Arguments.of(List.of(
                        new Developer("name1", Set.of("skill1")),
                        new Developer("name3", Set.of("skill1", "skill3"))),
                        "skill1"),
                Arguments.of(List.of(
                        new Developer("name2", Set.of("skill2", "skill3"))), "skill2 skill3"),
                Arguments.of(List.of(
                        new Developer("name2", Set.of("skill2", "skill3"))), "skill3 skill2 ")
        );
    }

    @Test
    void findAll() {
        List<Developer> result = developerService.findAll();

        int expected = 3;
        assertEquals(expected, result.size());
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findBy(List<Developer> expected, String skills) {
        List<Developer> result = developerService.findBy(skills);

        assertEquals(expected, result);
    }
}

