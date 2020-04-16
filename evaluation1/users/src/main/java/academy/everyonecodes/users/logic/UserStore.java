package academy.everyonecodes.users.logic;

import academy.everyonecodes.users.domain.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@ConfigurationProperties("user-account-store")
public class UserStore {

    private Set<User> users;

    void setUsers(Set<User> users) {
        this.users = users;
    }

    public Optional<User> getUserByEmail(String email){
        return users.stream()
                .filter(e-> e.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }
}
