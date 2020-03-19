package academy.everyonecodes.threepwoodCinema.Beans;

import academy.everyonecodes.threepwoodCinema.Template;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties("cinema.specialoffer")
public class TemplateMessageFinder {

    private List<Template> templates;
    private String defaultMessage;

    public TemplateMessageFinder(List<Template> templates) {
        this.templates = templates;
    }

    void setTemplates(List<Template> templates) {
        this.templates = templates;
    }

    void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String find(String name) {
        return templates.stream()
                .filter(template -> name.startsWith(template.getKeyword()))
                .map(template -> template.getMessage())
                .findFirst()
                .orElse(defaultMessage);

    }
}
