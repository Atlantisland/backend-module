package academy.everyonecodes.drhouseAccountancy.logic;

import academy.everyonecodes.drhouseAccountancy.persistence.domain.Invoice;
import academy.everyonecodes.drhouseAccountancy.persistence.domain.Patient;
import academy.everyonecodes.drhouseAccountancy.persistence.domain.PatientDto;
import academy.everyonecodes.drhouseAccountancy.persistence.repository.InvoiceRepository;
import academy.everyonecodes.drhouseAccountancy.persistence.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final InvoiceRepository invoiceRepository;
    private final double cost;

    public PatientService(PatientRepository patientRepository, InvoiceRepository invoiceRepository, @Value("${drhouse.invoice.cost}"double cost)) {
        this.patientRepository = patientRepository;
        this.invoiceRepository = invoiceRepository;
        this.cost = cost;
    }

    public Patient findOrSaveANew(PatientDto patientDto){
        Optional<Patient> oPatient = patientRepository.findByUuid(patientDto.getUuid());
        if(oPatient.isPresent()){
            return oPatient.get();

        }
        Patient patient = new Patient(
                patientDto.getUuid(),
                patientDto.getName(),
                patientDto.getSymptoms(),
                patientDto.getDiagnosis(),
                patientDto.getTreatment()
        );
        patientRepository.save(patient);
        invoice(patient);

        return patientDto;

        public void invoice(Patient patient){
            Invoice newInvoice = new Invoice(cost, false, patient);
            invoiceRepository.save(newInvoice);
        }
    }
}
//I need to stop here and to commit