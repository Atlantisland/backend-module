package academy.everyonecodes.marathon.logic;

import academy.everyonecodes.marathon.domain.Runner;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MarathonService {

    private final Set<Runner> runners = new HashSet<>();

    public void add(Runner runner) {
        runners.add(runner);
    }

    public Optional<Runner> findWinner() {
        return runners.stream()
                .min(Comparator.comparing(Runner::getDuration));
    }

    Set<Runner> getRunners() {
        return runners;
    }
}
