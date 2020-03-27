package academy.everyonecodes.drhouseAdmission.logic;

import academy.everyonecodes.drhouseAdmission.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Admission {

    private final UUIDProvider uuidProvider;

    public Admission(UUIDProvider uuidProvider) {
        this.uuidProvider = uuidProvider;
    }

    public Patient admit(Patient patient) {
        String uuid = UUID.randomUUID().toString();
        patient.setUuid(uuid);
        return uuidProvider.provideUUID(patient);
    }
}
