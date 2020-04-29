package academy.everyonecodes.mysteriousSecretOrder;

import academy.everyonecodes.mysteriousSecretOrder.persistence.domain.User;
import academy.everyonecodes.mysteriousSecretOrder.persistence.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class PrepareUserRunner {

    @Bean
    ApplicationRunner prepareMaster(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!userRepository.existsByUsername("mindfulness")) {
                String encodedPassword = passwordEncoder.encode("mindfulness");
                User user = new User("mindfulness", encodedPassword, Set.of("ROLE_MASTER"));
                userRepository.save(user);
            }
        };
    }
}
