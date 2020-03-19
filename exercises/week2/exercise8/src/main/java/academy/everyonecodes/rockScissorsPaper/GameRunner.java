package academy.everyonecodes.rockScissorsPaper;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameRunner {
    @Bean
    ApplicationRunner run(Game game) {
        return args -> {
            game.play();
        };
    }
}
