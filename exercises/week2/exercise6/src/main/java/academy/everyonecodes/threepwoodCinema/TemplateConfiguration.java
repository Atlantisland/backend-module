package academy.everyonecodes.threepwoodCinema;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("cinema.specialoffer")
public class TemplateConfiguration {
    private List<Template> templates;


    public void setTemplates(List<Template> templates) {
        this.templates = templates;
    }


    @Bean
    List<Template> templates() {
        return templates;
    }
}
