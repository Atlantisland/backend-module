package academy.everyonecodes.languageBarriers;

import academy.everyonecodes.languageBarriers.logic.InteractionsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class InteractionsScheduler {

    private final InteractionsService interactionsService;
    private final int amount;

    public InteractionsScheduler(InteractionsService interactionsService,
                                 @Value("${language-school.interactions.amount}") int amount) {
        this.interactionsService = interactionsService;
        this.amount = amount;
    }

    @Scheduled(fixedDelayString = "${language-school.interactions.delay}")
    public void addInteractions() {
        interactionsService.increaseNumberOfInteractionsBy(amount);
    }
}

