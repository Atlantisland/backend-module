package academy.everyonecodes.languageBarriers.communication;

import academy.everyonecodes.languageBarriers.logic.InteractionsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LanguageSchoolEndpoint {

    private final InteractionsService interactionsService;
    private final String everyone;
    private final String languages;
    private final String german;
    private final String english;

    public LanguageSchoolEndpoint(InteractionsService interactionsService,
                                  @Value("${language-school.messages.everyone}") String everyone,
                                  @Value("${language-school.messages.languages}") String languages,
                                  @Value("${language-school.messages.german}") String german,
                                  @Value("${language-school.messages.english}") String english) {
        this.interactionsService = interactionsService;
        this.everyone = everyone;
        this.languages = languages;
        this.german = german;
        this.english = english;
    }

    @GetMapping
    String getEveryone() {
        return everyone;
    }

    @GetMapping("/languages")
    @Secured("ROLE_USER")
    String getLanguages() {
        interactionsService.increaseNumberOfInteractionsByOne();
        return languages;
    }

    @GetMapping("/languages/german")
    @Secured("ROLE_LANGUAGE_GERMAN")
    String getGerman() {
        interactionsService.increaseNumberOfInteractionsByOne();
        return german;
    }

    @GetMapping("/languages/english")
    @Secured("ROLE_LANGUAGE_ENGLISH")
    String getEnglish() {
        interactionsService.increaseNumberOfInteractionsByOne();
        return english;
    }
}

