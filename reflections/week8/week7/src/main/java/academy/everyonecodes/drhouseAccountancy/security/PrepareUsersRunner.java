package academy.everyonecodes.drhouseAccountancy.security;

import academy.everyonecodes.drhouseAccountancy.persistence.domain.User;
import academy.everyonecodes.drhouseAccountancy.persistence.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class PrepareUsersRunner {

    @Bean
    ApplicationRunner prepareUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!userRepository.existsByUsername("walter")) {
                String encodedPassword = passwordEncoder.encode("secret321");
                User user = new User("mindfulness", encodedPassword, Set.of("ROLE_ACCOUNTANT"));
                userRepository.save(user);
            }

            if (!userRepository.existsByUsername("julia")) {
                String encodedPassword = passwordEncoder.encode("secret123");
                User user = new User("mindfulness", encodedPassword, Set.of("ROLE_ACCOUNTANT"));
                userRepository.save(user);
            }
        };
    }
}
