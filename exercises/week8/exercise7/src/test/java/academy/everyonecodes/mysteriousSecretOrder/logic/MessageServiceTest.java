package academy.everyonecodes.mysteriousSecretOrder.logic;

import academy.everyonecodes.mysteriousSecretOrder.persistence.domain.User;
import academy.everyonecodes.mysteriousSecretOrder.persistence.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class MessageServiceTest {

    @Autowired
    MessageService messageService;

    @MockBean
    UserRepository userRepository;

    @MockBean
    PasswordEncoder passwordEncoder;

    @Test
    void save() {
        String password = "password";
        String encoded = "passw0rd";

        User user = new User("user", password, Set.of("ROLE"));

        when(passwordEncoder.encode(password))
                .thenReturn(encoded);

        messageService.save(user);

        verify(passwordEncoder).encode(password);
        verify(userRepository).save(user);
    }

    @Test
    void findAll() {
        messageService.findAll();

        verify(userRepository).findAll();
    }

    @Test
    void findApprentices() {
        List<User> result = messageService.findApprentices();
        List<User> expected = List.of(new User("master", "master", Set.of("ROLE_MASTER", "ROLE_APPRENTICE")));

        assertEquals(expected, result);

        verify(userRepository).findByAuthorities("ROLE_MASTER");
    }
}