package academy.everyonecodes.marathonIntegration.logic;

import academy.everyonecodes.marathonIntegration.communication.client.MarathonClient;
import academy.everyonecodes.marathonIntegration.domain.Runner;
import academy.everyonecodes.marathonIntegration.domain.TestResult;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class MarathonTester {

    private final MarathonClient marathonClient;
    private final Runner winner;
    private final Set<Runner> runners;


    public MarathonTester(MarathonClient marathonClient, Runner winner, Set<Runner> runners) {
        this.marathonClient = marathonClient;
        this.winner = winner;
        this.runners = runners;
    }

    public TestResult performIntegrationTest(){
        Optional<Runner> oWinner = marathonClient.getWinner();
        if(oWinner.isPresent()) {
            return new TestResult("Error", "No winner should have been received in the first call");
        }
        runners.stream()
                .forEach(marathonClient::post);
        Optional<Runner> oWinnerFound = marathonClient.getWinner();
        if(!Optional.of(winner).equals(oWinnerFound)){
            return new TestResult("Error", "Incorrect winner received");
        }
        return new TestResult("Success", "Tests run correctly");
    }
}
