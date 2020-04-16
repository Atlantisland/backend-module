package academy.everyonecodes.punchCards.logic;

import academy.everyonecodes.punchCards.configuration.PunchCardRunner;
import academy.everyonecodes.punchCards.domain.PunchCard;
import academy.everyonecodes.punchCards.repository.PunchCardRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.any;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PunchCardServiceTest {

    @Autowired
    PunchCardService service;

    @MockBean
    PunchCardRepository repository;

    @MockBean
    PunchCardRunner runner;

    @Test
    void punch(){
       service.punch();

       Mockito.verify(repository).save(any(PunchCard.class));
    }
}