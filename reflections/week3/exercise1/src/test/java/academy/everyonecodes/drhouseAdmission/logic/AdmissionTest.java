package academy.everyonecodes.drhouseAdmission.logic;

import academy.everyonecodes.drhouseAdmission.communication.DiagnosesClient;
import academy.everyonecodes.drhouseAdmission.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AdmissionTest {

    @Autowired
    Admission admission;

    @MockBean
    UUIDProvider uuidProvider;

    @MockBean
    DiagnosesClient diagnosesClient;

    @Test
    void admit() {
        Patient patient = new Patient(null, "test", "test");

        admission.admit(patient);

        verify(uuidProvider).provideUUID(patient);
        verify(diagnosesClient).send(patient);
    }
}
