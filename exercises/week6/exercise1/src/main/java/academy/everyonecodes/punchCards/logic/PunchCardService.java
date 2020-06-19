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
        LocalDateTime now = LocalDateTime.now();
        String dayOfWeek = now.getDayOfWeek().toString();
        String timeOfDay = now.format(DateTimeFormatter.ISO_TIME);
        PunchCard punchCard = new PunchCard(dayOfWeek, timeOfDay);
        punchCardRepository.save(punchCard);
        System.out.println("Item saved: " + punchCard);
    }
}
