package academy.everyonecodes.drhouseAccountancy.logic;

import academy.everyonecodes.drhouseAccountancy.persistence.domain.Invoice;
import academy.everyonecodes.drhouseAccountancy.persistence.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public void markAsPaid(Long id) {
        Optional<Invoice> oInvoice = invoiceRepository.findById(id);
        if (oInvoice.isEmpty()) {
            return;
        }
        Invoice invoice = oInvoice.get();
        invoice.setPaid(true);
        invoiceRepository.save(invoice);
    }
}

