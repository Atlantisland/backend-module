package academy.everyonecodes.drhouseDiagnoses.logic;

import academy.everyonecodes.drhouseDiagnoses.communication.TreatmentsClient;
import academy.everyonecodes.drhouseDiagnoses.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DiagnosisRoomTest {

    @Autowired
    DiagnosisRoom diagnosisRoom;

    @MockBean
    DrHouse drHouse;

    @MockBean
    TreatmentsClient treatmentsClient;

    @Test
    void diagnose() {
        Patient patient = new Patient("test", "test", "test");

        diagnosisRoom.diagnose(patient);

        verify(drHouse).diagnose(patient);
        verify(treatmentsClient).send(patient);
    }
}


