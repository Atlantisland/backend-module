package academy.everyonecodes.marathon.logic;

import academy.everyonecodes.marathon.domain.Runner;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MarathonServiceTest {

    MarathonService service = new MarathonService();

    Runner runner1 = new Runner("Lisa", Duration.parse("PT1H1M34S"));
    Runner runner2 = new Runner("Mario", Duration.parse("PT1H15M34S"));
    Runner runner3 = new Runner("Luigi", Duration.parse("PT0H0M0S"));

    @Test
    void findWinner() {
        service.add(runner1);
        service.add(runner2);
        service.add(runner3);
        Optional<Runner> oResult = service.findWinner();

        Optional<Runner> oExpected = Optional.of(runner3);
        assertEquals(oExpected, oResult);
    }

    @Test
    void findNoWinner(){
        Optional<Runner> oResult = service.findWinner();

        Optional<Runner> oExpected = Optional.empty();
        assertEquals(oExpected, oResult);
    }

    @Test
    void add() {
        assertTrue(service.getRunners().isEmpty());

        Runner runner = new Runner("test", Duration.ofHours(1));
        service.add(runner);

        int expected = 1;
        assertEquals(expected, service.getRunners().size());
    }
}