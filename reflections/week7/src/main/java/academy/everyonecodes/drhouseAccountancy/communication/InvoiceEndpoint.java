package academy.everyonecodes.drhouseAccountancy.communication;

import academy.everyonecodes.drhouseAccountancy.logic.InvoiceService;
import academy.everyonecodes.drhouseAccountancy.persistence.domain.Invoice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceEndpoint {

    private final InvoiceService invoiceService;

    public InvoiceEndpoint(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    List<Invoice> findAll(){
        return invoiceService.findAll();
    }

    @PutMapping("{id}/paid")
    void put (@PathVariable Long id){
        invoiceService.pay(id);
    }
}
