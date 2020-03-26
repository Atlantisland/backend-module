package academy.everyonecodes.marathon.logic;

import academy.everyonecodes.marathon.domain.Runner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.Optional;
import java.util.Set;

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
        Optional<Runner> result = service.findWinner();
        assertEquals(Optional.of(runner3), result);
    }

    @Test
    void findNoWinner(){
        Optional<Runner> result = service.findWinner();
        assertEquals(Optional.empty(), result);
    }

    @Test
    void getRunners() {
        service.add(runner1);
        assertEquals(Set.of(runner1), service.getRunners());
    }
}