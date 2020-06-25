package academy.everyonecodes.registrations.logic;

import academy.everyonecodes.registrations.presistence.domain.Registration;
import academy.everyonecodes.registrations.presistence.domain.UdemyUser;
import academy.everyonecodes.registrations.presistence.repository.UdemyUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashSet;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UdemyUserServiceTest {

    @Autowired
    UdemyUserService udemyUserService;

    @MockBean
    UdemyUserRepository udemyUserRepository;

    String username = "username";
    Registration registration = new Registration(username, "course", "uuid", 49.20);
    UdemyUser udemyUser = new UdemyUser(username, new HashSet<>());

    @Test
    void findOrCreateFinds() {
        when(udemyUserRepository.findOneByUsername(username)).thenReturn(Optional.of(udemyUser));

        udemyUserService.findOrCreate(registration);

        verify(udemyUserRepository).findOneByUsername(username);
        verifyNoMoreInteractions(udemyUserRepository);
    }

    @Test
    void findOrCreates() {
        when(udemyUserRepository.findOneByUsername(username)).thenReturn(Optional.empty());

        udemyUserService.findOrCreate(registration);

        verify(udemyUserRepository).findOneByUsername(username);
        verify(udemyUserRepository).save(udemyUser);
    }

    @Test
    void save() {
        udemyUserService.save(udemyUser);

        verify(udemyUserRepository).save(udemyUser);
    }

    @Test
    void findAll() {
        udemyUserService.findAll();

        verify(udemyUserRepository).findAll();
    }
}
