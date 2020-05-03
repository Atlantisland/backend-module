package academy.everyonecodes.drhouseAccountancy.logic;

import academy.everyonecodes.drhouseAccountancy.persistence.domain.Invoice;
import academy.everyonecodes.drhouseAccountancy.persistence.domain.Patient;
import academy.everyonecodes.drhouseAccountancy.persistence.domain.PatientDto;
import academy.everyonecodes.drhouseAccountancy.persistence.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PatientServiceTest {

    @Autowired
    PatientService patientService;

    @MockBean
    InvoiceService invoiceService;

    @MockBean
    PatientRepository patientRepository;

    @Value("${drhouse.accountancy.cost}")
    double cost;

    @Test
    void invoiceDoesNotFindPatient() {
        String uuid = "uuid";
        PatientDto patientDTO = new PatientDto(uuid, "name", "symptoms", "diagnosis", "treatment");
        when(patientRepository.findByUuid(uuid))
                .thenReturn(Optional.empty());
        Patient patient = new Patient(uuid, "name", "symptoms", "diagnosis", "treatment");
        when(patientRepository.save(patient))
                .thenReturn(patient);

        patientService.invoice(patientDTO);

        verify(patientRepository).findByUuid(uuid);
        verify(patientRepository).save(patient);
        Invoice invoice = new Invoice(cost, patient);
        verify(invoiceService).save(invoice);
    }

    @Test
    void invoiceFindsPatient() {
        String uuid = "uuid";
        PatientDto patientDTO = new PatientDto(uuid, "name", "symptoms", "diagnosis", "treatment");
        Patient patient = new Patient(uuid, "name", "symptoms", "diagnosis", "treatment");
        when(patientRepository.findByUuid(uuid))
                .thenReturn(Optional.of(patient));

        patientService.invoice(patientDTO);

        verify(patientRepository).findByUuid(uuid);
        verifyNoMoreInteractions(patientRepository);
        Invoice invoice = new Invoice(cost, patient);
        verify(invoiceService).save(invoice);
    }
}