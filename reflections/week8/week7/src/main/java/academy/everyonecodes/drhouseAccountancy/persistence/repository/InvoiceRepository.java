package academy.everyonecodes.drhouseAccountancy.persistence.repository;

import academy.everyonecodes.drhouseAccountancy.persistence.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
