package academy.everyonecodes.marathonIntegration.communication.endpoint;

import academy.everyonecodes.marathonIntegration.domain.TestResult;
import academy.everyonecodes.marathonIntegration.logic.MarathonTester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marathon/integration")
public class MarathonIntegrationEndpoint {

    private final MarathonTester marathonTester;

    public MarathonIntegrationEndpoint(MarathonTester marathonTester) {
        this.marathonTester = marathonTester;
    }

    @GetMapping
    TestResult get() { return marathonTester.performIntegrationTest();
    }
}
