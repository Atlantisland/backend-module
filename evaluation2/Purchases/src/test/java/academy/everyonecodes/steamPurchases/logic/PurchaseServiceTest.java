package academy.everyonecodes.steamPurchases.logic;

import academy.everyonecodes.steamPurchases.persistence.domain.SteamUser;
import academy.everyonecodes.steamPurchases.persistence.repository.GameRepository;
import academy.everyonecodes.steamPurchases.persistence.repository.SteamUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PurchaseServiceTest {

@Autowired
    PurchaseService purchaseService;

@MockBean
    GameRepository gameRepository;

@MockBean
    SteamUserRepository steamUserRepository;

@Test
    void findAllSteamUsers(){

    purchaseService.findAllSteamUsers();

    verify(steamUserRepository).findAll();
}

@Test
    void findAll(){
    purchaseService.findAll();

    verify(gameRepository).findAll();
}

    @Test
    void purchaseFindsExistingUser() {
        String username = "username";
        SteamUser steamUser = new SteamUser();
        when(steamUserRepository.findOneByUsername(username))
                .thenReturn(Optional.of(steamUser));

        steamUserRepository.save(steamUser);

        verify(steamUserRepository).findOneByUsername(username);
        verifyNoMoreInteractions(steamUserRepository);
    }

    @Test
    void purchaseNotFindExistingUser() {
        String username = "username";
        when(steamUserRepository.findOneByUsername(username))
                .thenReturn(Optional.empty());
        SteamUser steamUser = new SteamUser();

        steamUserRepository.save(steamUser);

        verify(steamUserRepository).findOneByUsername(username);
        verify(steamUserRepository).save(steamUser);
    }
}