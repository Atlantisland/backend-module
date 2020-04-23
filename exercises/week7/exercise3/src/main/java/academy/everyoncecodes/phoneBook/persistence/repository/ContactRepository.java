package academy.everyoncecodes.phoneBook.persistence.repository;

import academy.everyoncecodes.phoneBook.persistence.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findContactByAddressPostalCode(String postalCode);
}
