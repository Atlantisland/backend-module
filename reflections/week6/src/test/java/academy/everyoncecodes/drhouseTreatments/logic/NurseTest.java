package academy.everyoncecodes.drhouseTreatments.logic;

import academy.everyoncecodes.drhouseTreatments.communication.client.AccountyncyClient;
import academy.everyoncecodes.drhouseTreatments.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class NurseTest {

    @Autowired
    Nurse nurse;

    @MockBean
    TreatmentService service;

    @MockBean
    AccountyncyClient accountancyClient;

    @Value("${drhouse.treatments.default}")
    String treatment;

    @Test
    void treat() {
        Patient patient = new Patient("uuid", "name", "symptoms", "diagnosis");
        assertNull(patient.getTreatment());

        nurse.treat(patient);

        assertNotNull(patient.getTreatment());
        assertEquals(treatment, patient.getTreatment());
        verify(service).save(patient);
        verify(accountancyClient).send(patient);
    }
}