package academy.everyonecodes.registrations.logic;

import academy.everyonecodes.registrations.presistence.domain.Registration;
import academy.everyonecodes.registrations.presistence.domain.UdemyUser;
import academy.everyonecodes.registrations.presistence.repository.UdemyUserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UdemyUserService {

    private final UdemyUserRepository udemyUserRepository;

    public UdemyUserService(UdemyUserRepository udemyUserRepository) {
        this.udemyUserRepository = udemyUserRepository;
    }

    public UdemyUser findOrCreate(Registration registration) {
        return udemyUserRepository.findOneByUsername(registration.getUsername())
                .orElseGet(() -> createUser(registration));
    }

    private UdemyUser createUser(Registration registration) {
        UdemyUser udemyUser = new UdemyUser(registration.getUsername(), new HashSet<>());
        return udemyUserRepository.save(udemyUser);
    }

    public void save(UdemyUser udemyUser) {
        udemyUserRepository.save(udemyUser);
    }

    public List<UdemyUser> findAll() {
        return udemyUserRepository.findAll();
    }
}
