package academy.everyonecodes.users.logic;

import academy.everyonecodes.users.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UserStoreTest {

    @Autowired
    UserStore userStore;

    static Stream<Arguments> parameters() {
        return Stream.of(
                of(Optional.empty(), ""),
                of(Optional.empty(), "test"),
                of(Optional.of(new User("test", "test@test.com", "test")), "test@test.com")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findByEmail(Optional<User> oExpected, String email) {
        Optional<User> oResult = userStore.getUserByEmail(email);

        assertEquals(oExpected, oResult);
    }
}



