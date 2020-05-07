package academy.everyonecodes.steamUsers;

import academy.everyonecodes.steamUsers.peristence.domain.SteamUser;
import academy.everyonecodes.steamUsers.peristence.repository.SteamUserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ConfigurationProperties("steam-users")
public class UserRunner {

    private SteamUser appuser;

    @Bean
    ApplicationRunner ensureAdminUser(SteamUserRepository steamUserRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (steamUserRepository.existsByUsername(appuser.getUsername())) {
                return;
            }
            String password = appuser.getPassword();
            String encoded = passwordEncoder.encode(password);
            appuser.setPassword(encoded);
            steamUserRepository.save(appuser);
        };
    }

    void setAppuser(SteamUser appuser) {
        this.appuser = appuser;
    }
}
