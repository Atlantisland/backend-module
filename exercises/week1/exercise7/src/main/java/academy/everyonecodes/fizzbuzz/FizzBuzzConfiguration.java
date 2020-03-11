package academy.everyonecodes.fizzbuzz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FizzBuzzConfiguration {

    @Bean
    FizzBuzz fizzBuzz(MultipleFinder multipleOfThree, MultipleFinder multipleOfFive) {
        return new FizzBuzz(multipleOfThree, multipleOfFive);
    }
}
