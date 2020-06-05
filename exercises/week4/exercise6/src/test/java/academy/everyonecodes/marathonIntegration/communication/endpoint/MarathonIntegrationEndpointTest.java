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
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MarathonIntegrationEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    MarathonTester marathonTester;

    String url = "/marathon/integration";

    @Test
    void getIntegrationTestResult() {
        TestResult expected = new TestResult("test", "test");
        when(marathonTester.performIntegrationTest())
                .thenReturn(expected);

        TestResult response = testRestTemplate.getForObject(url, TestResult.class);

        assertEquals(expected, response);
        Mockito.verify(marathonTester).performIntegrationTest();
    }
}