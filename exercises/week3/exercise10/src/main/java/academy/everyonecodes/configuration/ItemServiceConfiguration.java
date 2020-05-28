package academy.everyonecodes.configuration;

import academy.everyonecodes.logic.ItemService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class ItemServiceConfiguration {

    @Bean
    ItemService itemService(){
        return new ItemService(new ArrayList<>());
    }
}
