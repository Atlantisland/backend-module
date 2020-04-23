package academy.everyoncecodes.phoneBook.persistence.repository;

import academy.everyoncecodes.phoneBook.persistence.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
