package academy.everyonecodes.wizard.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Wizard {

    private final String homeUrl;

    public Wizard(@Value("${home.url}") String homeUrl) {
        this.homeUrl = homeUrl;
    }

    public String getHomeUrl(){
        return homeUrl;
    }
}
