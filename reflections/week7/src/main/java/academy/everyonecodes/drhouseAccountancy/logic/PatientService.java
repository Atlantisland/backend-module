package academy.everyonecodes.drhouseAccountancy.logic;

import academy.everyonecodes.drhouseAccountancy.persistence.domain.Invoice;
import academy.everyonecodes.drhouseAccountancy.persistence.domain.Patient;
import academy.everyonecodes.drhouseAccountancy.persistence.domain.PatientDto;
import academy.everyonecodes.drhouseAccountancy.persistence.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final InvoiceService invoiceService;
    private final PatientRepository patientRepository;
    private final double cost;

    public PatientService(InvoiceService invoiceService, PatientRepository patientRepository,
                      @Value("${drhouse.accountancy.cost}") double cost) {
        this.invoiceService = invoiceService;
        this.patientRepository = patientRepository;
        this.cost = cost;
    }
    public void invoice(PatientDto patientDTO) {
        Patient patient = findOrCreateNew(patientDTO);
        Invoice invoice = generateInvoice(patient);
        invoiceService.save(invoice);
    }

    private Patient findOrCreateNew(PatientDto patientDto) {
        return patientRepository.findByUuid(patientDto.getUuid())
                .orElseGet(() -> createNew(patientDto));
    }

    private Patient createNew(PatientDto patientDTO) {
        Patient patient = new Patient(patientDTO.getUuid(),
                patientDTO.getName(),
                patientDTO.getSymptoms(),
                patientDTO.getDiagnosis(),
                patientDTO.getTreatment()
        );
        return patientRepository.save(patient);
    }

    private Invoice generateInvoice(Patient patient) {
        return new Invoice(cost, patient);
    }
}
