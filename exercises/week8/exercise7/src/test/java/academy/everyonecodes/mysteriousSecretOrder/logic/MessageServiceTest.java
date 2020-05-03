package academy.everyonecodes.mysteriousSecretOrder.logic;

import academy.everyonecodes.mysteriousSecretOrder.persistence.domain.User;
import academy.everyonecodes.mysteriousSecretOrder.persistence.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
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

    @Value("${mysterious-secret-order.apprentice.authorities}")
    String apprenticeAuthorities;

    @Test
    void findAll() {
        messageService.findAll();

        verify(userRepository).findAll();
    }

    @Test
    void findApprentices() {
        messageService.findApprentices();

        verify(userRepository).findByAuthorities(apprenticeAuthorities);
    }

    @Test
    void save() {
        User user = new User("username", "password", Set.of("ROLE_TEST"));
        when(passwordEncoder.encode("password"))
                .thenReturn("encrypted");

        messageService.save(user);

        User expected = new User("username", "encrypted", Set.of("ROLE_TEST"));
        verify(userRepository).save(expected);
    }
}