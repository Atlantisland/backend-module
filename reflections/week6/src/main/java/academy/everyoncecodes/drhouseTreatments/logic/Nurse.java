package academy.everyoncecodes.drhouseTreatments.logic;

import academy.everyoncecodes.drhouseTreatments.communication.client.AccountyncyClient;
import academy.everyoncecodes.drhouseTreatments.domain.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Nurse {

    private final TreatmentService treatmentService;
    private final AccountyncyClient accountancyClient;
    private final String treatment;

    public Nurse(TreatmentService treatmentService,
                 AccountyncyClient accountancyClient,
                 @Value("${drhouse.treatments.default}") String treatment) {
        this.treatmentService = treatmentService;
        this.accountancyClient = accountancyClient;
        this.treatment = treatment;
    }

    public void treat(Patient patient) {
        patient.setTreatment(treatment);
        treatmentService.save(patient);
        accountancyClient.send(patient);
    }
}


