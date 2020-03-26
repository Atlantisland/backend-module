package academy.everyonecodes.advancedTypes.configuration;

import academy.everyonecodes.advancedTypes.domain.Academy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("education")
public class AcademyConfiguration {

    private List<Academy> academies;

    @Bean
    List<Academy> academies(){
        return academies;
    }

    void setAcademies(List<Academy> academies){
        this.academies = academies;
    }
}
