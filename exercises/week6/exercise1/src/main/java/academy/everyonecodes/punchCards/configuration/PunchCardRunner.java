package academy.everyonecodes.punchCards.configuration;

import academy.everyonecodes.punchCards.logic.PunchCardService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PunchCardRunner {

    @Bean
    ApplicationRunner runner(PunchCardService punchCardService) {
        return args -> punchCardService.punch();
    }
}
