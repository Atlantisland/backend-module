package academy.everyonecodes.udemyUsers.logic;

import academy.everyonecodes.udemyUsers.peristence.domain.UdemyUser;
import academy.everyonecodes.udemyUsers.peristence.repository.UdemyUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UdemyUserServiceTest {

    @Autowired
    UdemyUserService udemyUserService;

    @MockBean
    UdemyUserRepository udemyUserRepository;

    @MockBean
    PasswordEncoder passwordEncoder;

    @Value("${users.authorities}")
    Set<String> authorities;

    @Test
    void saveUserThatAlreadyExists() {
        String username = "username";
        UdemyUser udemyUser = new UdemyUser(username, "password");
        when(udemyUserRepository.findOneByUsername(username))
                .thenReturn(Optional.of(udemyUser));

        udemyUserService.save(udemyUser);

        verify(udemyUserRepository).findOneByUsername(username);
        verifyNoMoreInteractions(udemyUserRepository);
        verifyNoInteractions(passwordEncoder);
    }

    @Test
    void saveUserThatDoesNotExist() {
        String username = "username";
        String password = "password";
        UdemyUser udemyUser = new UdemyUser(username, password);
        when(passwordEncoder.encode(password))
                .thenReturn(password);
        when(udemyUserRepository.findOneByUsername(username))
                .thenReturn(Optional.empty());

        udemyUserService.save(udemyUser);

        verify(udemyUserRepository).findOneByUsername(username);
        verify(passwordEncoder).encode(password);
        verify(udemyUserRepository).save(new UdemyUser(username, password, authorities));
    }
}