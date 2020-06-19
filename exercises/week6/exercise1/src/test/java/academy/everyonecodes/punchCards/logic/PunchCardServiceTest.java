package academy.everyonecodes.punchCards.logic;

import academy.everyonecodes.punchCards.domain.PunchCard;
import academy.everyonecodes.punchCards.repository.PunchCardRepository;
import academy.everyonecodes.punchCards.configuration.PunchCardRunner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PunchCardServiceTest {

    @Autowired
    PunchCardService punchCardService;

    @MockBean
    PunchCardRepository punchCardRepository;

    @MockBean
    PunchCardRunner punchCardRunner;

    @Test
    void punch(){
        punchCardService.punch();

        verify(punchCardRepository).save(any(PunchCard.class));
    }
}