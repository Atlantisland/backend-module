package academy.everyonecodes.threepwoodCinema.Beans;

import academy.everyonecodes.threepwoodCinema.Template;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateMessageFinder {

    private final List<Template> templates;
    private final String defaultMessage;

    public TemplateMessageFinder(List<Template> templates, @Value("${cinema.specialoffer.defaultMessage}") String defaultMessage) {

        this.templates = templates;
        this.defaultMessage = defaultMessage;
    }

    public String find(String customerName) {
        return templates.stream()
                .filter(template -> customerName.contains(template.getKeyword()))
                .map(Template::getMessage)
                .map(message -> adapt(message, customerName))
                .findFirst()
                .orElse(adapt(defaultMessage, customerName));
    }

    private String adapt(String message, String customerName) {
        return message.replaceAll("--name--", customerName);
    }
}
