package academy.everyonecodes.drhouseAdmission.logic;

import academy.everyonecodes.drhouseAdmission.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdmissionTest {

    @Autowired
    Admission admission;

    @Test
    void admit() {
        Patient patient = new Patient(null, "test", "test");
        assertNull(patient.getUuid());

        Patient result = admission.admit(patient);

        assertNotNull(result.getUuid());
    }
}
