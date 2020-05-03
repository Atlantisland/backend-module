package academy.everyonecodes.mysteriousSecretOrder;

import academy.everyonecodes.mysteriousSecretOrder.persistence.domain.User;
import academy.everyonecodes.mysteriousSecretOrder.persistence.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.lang.reflect.Member;

@Configuration
@ConfigurationProperties("mysterious-secret-order")
public class PrepareUserRunner {

    private User master;

    @Bean
    ApplicationRunner ensureAdminUser(UserRepository memberRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (memberRepository.existsByUsername(master.getUsername())) {
                return;
            }
            String password = master.getPassword();
            String encoded = passwordEncoder.encode(password);
            master.setPassword(encoded);
            memberRepository.save(master);
        };
    }

    void setUser(User master) {
        this.master = master;
    }
}
