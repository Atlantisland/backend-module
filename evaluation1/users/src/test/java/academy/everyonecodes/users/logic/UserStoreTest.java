package academy.everyonecodes.users.logic;

import academy.everyonecodes.users.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UserStoreTest {

    @Autowired
    UserStore store;

    @Test
    void getNoUserByEmail() {
        User user = new User("user2", "email2", "");
        Optional<User> oResult = store.getUserByEmail("email2");
        Optional<User> oExpected = Optional.empty();
        Assertions.assertEquals(oExpected, oResult);
    }

    @Test
    void getUserByEmail() {
        User user = new User("user1", "email1", "type1");
        Optional<User> oResult = store.getUserByEmail("email1");
        Optional<User> oExpected = Optional.of(user);
        Assertions.assertEquals(oExpected, oResult);
    }
}


