package academy.everyonecodes.marathonIntegration.communication.endpoint;

import academy.everyonecodes.marathonIntegration.domain.TestResult;
import academy.everyonecodes.marathonIntegration.logic.MarathonTester;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MarathonIntegrationEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    MarathonTester marathonTester;

    @Test
    void getIntegrationTestResult() {
        String url = "/marathon/integration";
        testRestTemplate.getForObject(url, TestResult.class);
        Mockito.verify(marathonTester).performIntegrationTest();
    }
}