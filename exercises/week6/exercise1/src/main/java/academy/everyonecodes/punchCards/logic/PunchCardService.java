package academy.everyonecodes.punchCards.logic;

import academy.everyonecodes.punchCards.domain.PunchCard;
import academy.everyonecodes.punchCards.repository.PunchCardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PunchCardService {

    private final PunchCardRepository punchCardRepository;

    public PunchCardService(PunchCardRepository punchCardRepository) {
        this.punchCardRepository = punchCardRepository;
    }

    public void punch() {
        PunchCard card = create();
        punchCardRepository.save(card);
        System.out.println("Item saved: " + card);
    }

    private PunchCard create() {
        String dayOfWeek = LocalDateTime.now().toString();
        String timeOfDay = LocalDateTime.now().format(DateTimeFormatter.ISO_TIME);
        return new PunchCard(dayOfWeek, timeOfDay);
    }
}
