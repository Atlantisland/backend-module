package academy.everyonecodes.marathonIntegration.configuration;

import academy.everyonecodes.marathonIntegration.domain.Runner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
@ConfigurationProperties("integration")
public class RunnerConfiguration {

    private Runner winner;
    private Set<Runner> runners;

    void setWinner(Runner winner) {
        this.winner = winner;
    }

    void setRunners(Set<Runner> runners) {
        this.runners = runners;
    }

    @Bean
    Runner winner(){
        return winner;
    }

    @Bean
    Set<Runner> runner(){
        return runners;
    }
}
