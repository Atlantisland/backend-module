package academy.everyonecodes.steamUsers.logic;

import academy.everyonecodes.steamUsers.peristence.domain.SteamUser;
import academy.everyonecodes.steamUsers.peristence.repository.SteamUserRepository;
import org.junit.jupiter.api.Assertions;
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
class SteamUserServiceTest {

    @Autowired
    SteamUserService steamUserService;

    @MockBean
    SteamUserRepository steamUserRepository;

    @MockBean
    PasswordEncoder passwordEncoder;

    @Value("${steam-users.regularuser.authorities}")
    Set<String> authorities;

    @Value("${steam-users.message}")
    String message;

    @Test
    void  saveNonExistingSteamUser() {
        String username = "username";
        SteamUser steamUser = new SteamUser();
        when(steamUserRepository.findOneByUsername(username))
                .thenReturn(Optional.empty());
        when(passwordEncoder.encode(username))
                .thenReturn("encrypted");

        assertTrue(steamUser.getAuthorities().isEmpty());

        steamUserService.save(steamUser);

        assertTrue(steamUser.getAuthorities().contains(authorities));
        assertEquals(1, steamUser.getAuthorities().size());
        SteamUser expected = new SteamUser(username, "encrypted", authorities);

        verify(steamUserRepository).findOneByUsername(username);
        verify(steamUserRepository).save(expected);
    }

    @Test
    void saveFindsExistingSteamUser() {
        String username = "username";
        SteamUser expected = new SteamUser();

        when(steamUserRepository.findOneByUsername(username))
                .thenReturn(Optional.of(expected));

        steamUserService.save(expected);

        verify(steamUserRepository).findOneByUsername(username);
        verifyNoInteractions(passwordEncoder);
        verifyNoMoreInteractions(steamUserRepository);
    }

    @Test
    void login() {
        String result = steamUserService.login();
        String expected = message;

        Assertions.assertEquals(expected, result);
    }
}