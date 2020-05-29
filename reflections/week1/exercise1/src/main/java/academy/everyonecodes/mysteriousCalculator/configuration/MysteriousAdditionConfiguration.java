package academy.everyonecodes.mysteriousCalculator.configuration;

import academy.everyonecodes.mysteriousCalculator.logic.MysteriousAddition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MysteriousAdditionConfiguration {

    @Bean
    MysteriousAddition mysteriousAdditionOne(){
        return new MysteriousAddition(1);
    }

    @Bean
    MysteriousAddition mysteriousAdditionTwo(){
        return new MysteriousAddition(2);
    }
}
