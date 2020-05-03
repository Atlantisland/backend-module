package academy.everyonecodes.authorizedMarco.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateConfiguration {

    @Bean
    RestTemplate restTemplate(@Value("${marco-polo.authentication.username}") String username,
                              @Value("${marco-polo.authentication.username}") String password) {
        return new RestTemplateBuilder()
                .basicAuthentication(username, password)
                .build();
    }
}


