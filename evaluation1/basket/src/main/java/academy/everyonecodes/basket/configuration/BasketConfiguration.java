package academy.everyonecodes.basket.configuration;

import academy.everyonecodes.basket.logic.Basket;
import academy.everyonecodes.basket.logic.SummaryCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class BasketConfiguration {

    @Bean
    Basket basket(SummaryCalculator summaryCalculator){
        return new Basket(summaryCalculator, new ArrayList<>());
    }
}
