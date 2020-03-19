package academy.everyonecodes.rockScissorsPaper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfiguration {

    @Bean
    Human player1(MoveUtils moveUtils) {
        return new Human(moveUtils);
    }

    @Bean
    Computer player2(List<Move> moves) {
        return new Computer(moves);
    }
}
