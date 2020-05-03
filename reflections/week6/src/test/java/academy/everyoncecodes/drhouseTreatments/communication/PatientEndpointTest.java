package academy.everyoncecodes.drhouseTreatments.communication;

import academy.everyoncecodes.drhouseTreatments.domain.Patient;
import academy.everyoncecodes.drhouseTreatments.logic.Nurse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PatientEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    Nurse nurse;

    String url = "/patients";

    @Test
    void post(){
        Patient patient = new Patient("uuid", "name", "symptoms", "diagnosis");
        testRestTemplate.postForObject(url, patient, Patient.class);

        verify(nurse).treat(patient);
    }
}