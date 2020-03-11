package academy.everyonecodes.fizzbuzz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleFinderConfiguration {

    @Bean
    MultipleFinder multipleOfThree() {
        return new MultipleFinder(3);
    }

    @Bean
    MultipleFinder multipleOfFive() {
        return new MultipleFinder(5);
    }

}
