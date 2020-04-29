package academy.everyonecodes.securedPolo.logic;

import org.springframework.stereotype.Service;

@Service
public class Polo {

    public String giveResponse(String message) {
        String response = "";
        if (message.equals("Marco")) {
            response = "Polo";
        } else {
            response = "What?";
        }
        return response;
    }
}
