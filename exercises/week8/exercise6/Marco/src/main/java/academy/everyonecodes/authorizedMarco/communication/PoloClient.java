package academy.everyonecodes.authorizedMarco.communication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class PoloClient {

    private final RestTemplate restTemplate;
    private final String url;

    public PoloClient(RestTemplate restTemplate,
                      @Value("${message.server.url}") String url)
    {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public String post(String message){
        return restTemplate.postForObject(url + "/" + message, message, String.class);
    }
}
