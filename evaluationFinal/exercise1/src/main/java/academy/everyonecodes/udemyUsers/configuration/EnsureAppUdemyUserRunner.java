package academy.everyonecodes.udemyUsers.configuration;

import academy.everyonecodes.udemyUsers.peristence.domain.UdemyUser;
import academy.everyonecodes.udemyUsers.peristence.repository.UdemyUserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ConfigurationProperties("users")
public class EnsureAppUdemyUserRunner {

    private UdemyUser app;

    void setApp(UdemyUser app) {
        this.app = app;
    }

    @Bean
    ApplicationRunner ensureAppUdemyUser(UdemyUserRepository udemyUserRepository,
                                         PasswordEncoder passwordEncoder) {
        return args -> {
            if (udemyUserRepository.existsByUsername(app.getUsername())) {
                return;
            }
            String password = app.getPassword();
            String encoded = passwordEncoder.encode(password);
            app.setPassword(encoded);
            udemyUserRepository.save(app);
        };
    }
}
