package academy.everyonecodes.drhouseDiagnoses.communication;

import academy.everyonecodes.drhouseDiagnoses.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TreatmentsClientTest {

    @Autowired
    TreatmentsClient treatmentsClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${drhouse.treatments.url}")
    String url;

    @Test
    void send() {
        Patient patient = new Patient("uuid", "name", "symptoms", "diagnosis");

        treatmentsClient.send(patient);

        verify(restTemplate).postForObject(url, patient, Void.class);
    }
}
