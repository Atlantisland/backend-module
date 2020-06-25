package academy.everyonecodes.udemyUsers.logic;

import academy.everyonecodes.udemyUsers.peristence.domain.UdemyUser;
import academy.everyonecodes.udemyUsers.peristence.repository.UdemyUserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UdemyUserService {

    private final UdemyUserRepository udemyUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final Set<String> authorities;

    public UdemyUserService(UdemyUserRepository udemyUserRepository,
                            PasswordEncoder passwordEncoder,
                            @Value("${users.authorities}") Set<String> authorities) {
        this.udemyUserRepository = udemyUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorities = authorities;
    }

    public UdemyUser save(UdemyUser udemyUser) {
        return udemyUserRepository.findOneByUsername(udemyUser.getUsername())
                .orElseGet(() -> create(udemyUser));
    }

    private UdemyUser create(UdemyUser udemyUser) {
        String encoded = passwordEncoder.encode(udemyUser.getPassword());
        udemyUser.setPassword(encoded);
        udemyUser.setAuthorities(authorities);
        return udemyUserRepository.save(udemyUser);
    }
}
