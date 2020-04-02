package academy.everyonecodes.marathonIntegration.configuration;

import academy.everyonecodes.marathonIntegration.domain.Runner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Set;

@Configuration
public class RunnerConfiguration {

    @Bean
    Runner winner(){
        return new Runner("winner", Duration.ofSeconds(1));
    }

    @Bean
    Set<Runner> runnerList(){
        return Set.of(
                new Runner("winner", Duration.ofSeconds(1)),
                new Runner("runner2", Duration.ofSeconds(2)),
                new Runner("runner3", Duration.ofSeconds(3)));
    }
}
