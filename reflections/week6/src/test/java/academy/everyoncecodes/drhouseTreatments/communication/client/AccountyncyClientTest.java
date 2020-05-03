package academy.everyoncecodes.drhouseTreatments.communication.client;

import academy.everyoncecodes.drhouseTreatments.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AccountyncyClientTest {

    @Autowired
    AccountyncyClient accountancyClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${drhouse.accountancy.url}")
    String url;

    @Test
    void send() {
        Patient patient = new Patient("uuid", "name", "symptoms", "diagnosis", "treatment");

        accountancyClient.send(patient);

        verify(restTemplate).postForObject(url, patient, Void.class);
    }
}