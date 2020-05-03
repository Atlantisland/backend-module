package academy.everyonecodes.mysteriousSecretOrder.logic;

import academy.everyonecodes.mysteriousSecretOrder.persistence.domain.User;
import academy.everyonecodes.mysteriousSecretOrder.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final String apprentices;

    public MessageService(UserRepository repository, PasswordEncoder encoder,
                        @Value("${mysterious-secret-order.apprentice.authorities}") String apprentices) {
        this.repository = repository;
        this.encoder = encoder;
        this.apprentices = apprentices;
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public List<User> findApprentices(){
        return repository.findByAuthorities(apprentices);
    }

    public User save(User user) {
        String password = user.getPassword();
        String encoded = encoder.encode(password);
        user.setPassword(encoded);
        return repository.save(user);
    }
}
