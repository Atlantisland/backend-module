package academy.everyonecodes.home.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Home {

    private final String message;

    public Home(@Value("${home.message}") String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
