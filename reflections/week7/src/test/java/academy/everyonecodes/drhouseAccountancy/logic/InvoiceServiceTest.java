package academy.everyonecodes.drhouseAccountancy.logic;

import academy.everyonecodes.drhouseAccountancy.persistence.domain.Invoice;
import academy.everyonecodes.drhouseAccountancy.persistence.domain.Patient;
import academy.everyonecodes.drhouseAccountancy.persistence.repository.InvoiceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class InvoiceServiceTest {

    @Autowired
    InvoiceService invoiceService;

    @MockBean
    InvoiceRepository invoiceRepository;

    @Test
    void findAll() {
        invoiceService.findAll();
    }

    @Test
    void save() {
        Invoice invoice = new Invoice(0.0, new Patient());
        invoiceService.save(invoice);
        verify(invoiceRepository).save(invoice);
    }

    @Test
    void markAsPaidDoesNotFindInvoice() {
        Long id = 123L;
        when(invoiceRepository.findById(id)).thenReturn(Optional.empty());
        invoiceService.markAsPaid(id);
        verify(invoiceRepository).findById(id);
        verifyNoMoreInteractions(invoiceRepository);
    }

    @Test
    void markAsPaidFindsInvoice() {
        Long id = 123L;
        Invoice invoice = new Invoice(0, false, new Patient());
        when(invoiceRepository.findById(id))
                .thenReturn(Optional.of(invoice));
        assertFalse(invoice.isPaid());

        invoiceService.markAsPaid(id);

        verify(invoiceRepository).findById(id);
        Invoice expected = new Invoice(0, true, new Patient());
        verify(invoiceRepository).save(expected);
    }
}