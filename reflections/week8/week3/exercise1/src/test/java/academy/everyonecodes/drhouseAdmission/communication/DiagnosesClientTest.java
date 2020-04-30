package academy.everyonecodes.drhouseAdmission.communication;

import academy.everyonecodes.drhouseAdmission.domain.Patient;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DiagnosesClientTest {

    @Autowired
    DiagnosesClient diagnosesClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${drhouse.diagnoses.url}")
    String mockServerUri;

    @Test
    void send() throws JsonProcessingException {
        Patient patient = new Patient("UUID", "test", "test");

        diagnosesClient.send(patient);

        verify(restTemplate).postForObject(mockServerUri, patient, Void.class);
    }
}
