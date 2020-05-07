package academy.everyonecodes.steamUsers.logic;

import academy.everyonecodes.steamUsers.peristence.domain.SteamUser;
import academy.everyonecodes.steamUsers.peristence.repository.SteamUserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SteamUserService {

    private final SteamUserRepository steamUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final Set<String> authorities;
    private final String message;

    public SteamUserService(SteamUserRepository steamUserRepository,
                            PasswordEncoder passwordEncoder,
                            @Value("${steam-users.regularuser.authorities}") Set<String> authorities,
                            @Value("${steam-users.message}") String message) {
        this.steamUserRepository = steamUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorities = authorities;
        this.message = message;
    }


    public SteamUser save(SteamUser steamUser){
        return steamUserRepository.findOneByUsername(steamUser.getUsername())
                .orElseGet(() -> create(steamUser));
    }

    private SteamUser create(SteamUser steamUser){
        String encoded = passwordEncoder.encode((steamUser.getPassword()));
        steamUser.setPassword(encoded);
        steamUser.setAuthorities(authorities);
        return steamUserRepository.save(steamUser);
    }

    public String login(){
        return message;
    }
}
