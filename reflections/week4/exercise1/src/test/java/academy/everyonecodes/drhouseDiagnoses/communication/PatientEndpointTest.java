package academy.everyonecodes.drhouseDiagnoses.communication;

import academy.everyonecodes.drhouseDiagnoses.domain.Patient;
import academy.everyonecodes.drhouseDiagnoses.logic.DiagnosisRoom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    DiagnosisRoom diagnosisRoom;

    String url = "/patients";

    @Test
    void post() {
        Patient patient = new Patient("test", "test", "test");

        restTemplate.postForObject(url, patient, Patient.class);

        verify(diagnosisRoom).diagnose(patient);
    }
}

