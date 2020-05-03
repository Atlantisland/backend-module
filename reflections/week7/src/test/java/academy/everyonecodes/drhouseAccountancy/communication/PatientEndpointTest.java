package academy.everyonecodes.drhouseAccountancy.communication;

import academy.everyonecodes.drhouseAccountancy.logic.PatientService;
import academy.everyonecodes.drhouseAccountancy.persistence.domain.PatientDto;
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
    PatientService patientService;

    String url = "/patients";

    @Test
    void post(){
        PatientDto patientDTO = new PatientDto("uuid", "name", "symptoms", "diagnosis", "treatment");

        testRestTemplate.postForObject(url, patientDTO, PatientDto.class);

        verify(patientService).invoice(patientDTO);

    }
}