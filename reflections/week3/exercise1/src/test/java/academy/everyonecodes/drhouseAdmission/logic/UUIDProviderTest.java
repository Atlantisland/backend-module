package academy.everyonecodes.drhouseAdmission.logic;

import academy.everyonecodes.drhouseAdmission.domain.Patient;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UUIDProviderTest {

    UUIDProvider uuidProvider = new UUIDProvider();

    @Test
    void provideUUIDUnknownPatient() {
        Patient patient = new Patient(null, "test", "test");

        uuidProvider.provideUUID(patient);

        assertNotNull(patient.getUuid());
    }

    @Test
    void provideUUIDKnownPatient() {
        Patient patient = new Patient(null, "first", "test");
        assertNull(patient.getUuid());

        uuidProvider.provideUUID(patient);

        String uuid1 = patient.getUuid();
        assertNotNull(uuid1);

        uuidProvider.provideUUID(patient);

        String uuid2 = patient.getUuid();
        assertNotNull(uuid2);
        assertEquals(uuid1, uuid2);

        Patient other = new Patient(null, "other", "test");
        assertNull(other.getUuid());

        uuidProvider.provideUUID(other);

        String uuidOther = other.getUuid();
        assertNotNull(uuidOther);
        assertNotEquals(uuid1, uuidOther);
    }

    @Test
    void findUUID() {
        Optional<String> oResult = uuidProvider.findUUID("unknown");
        assertTrue(oResult.isEmpty());

        String patientName = "Test Find";
        Patient patient = new Patient(null, patientName, "test");
        uuidProvider.provideUUID(patient);
        String uuid = patient.getUuid();

        oResult = uuidProvider.findUUID(patientName);
        assertTrue(oResult.isPresent());
        assertEquals(uuid, oResult.get());
    }
}