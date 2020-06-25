package academy.everyonecodes.udemyUsers.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoginUdemyService {

    private final String message;

    public LoginUdemyService(@Value("${users.login.message}") String message) {
        this.message = message;
    }

    public String login() {
        return message;
    }
}
