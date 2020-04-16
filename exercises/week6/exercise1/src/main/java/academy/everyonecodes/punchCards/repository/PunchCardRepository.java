package academy.everyonecodes.punchCards.repository;

import academy.everyonecodes.punchCards.domain.PunchCard;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PunchCardRepository extends MongoRepository<PunchCard, String> {
}
