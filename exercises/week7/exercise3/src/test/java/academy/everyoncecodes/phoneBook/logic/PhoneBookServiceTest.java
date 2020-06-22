package academy.everyoncecodes.phoneBook.logic;

import academy.everyoncecodes.phoneBook.persistence.domain.Address;
import academy.everyoncecodes.phoneBook.persistence.domain.Contact;
import academy.everyoncecodes.phoneBook.persistence.repository.AddressRepository;
import academy.everyoncecodes.phoneBook.persistence.repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PhoneBookServiceTest {

    @Autowired
    PhoneBookService phoneBookService;

    @MockBean
    ContactRepository contactRepository;

    @MockBean
    AddressRepository addressRepository;

    @Test
    void findAll(){
        phoneBookService.findAll();

        verify(contactRepository).findAll();
    }

    @Test
    void save(){
        Contact contact = new Contact("name", new Address("street", "1234"));

        phoneBookService.save(contact);

        verify(addressRepository).save(contact.getAddress());
        verify(contactRepository).save(contact);
    }

    @Test
    void findByAddressPostalCode(){
        String postalCode = "postalCode";

        phoneBookService.findByAddressPostalCode(postalCode);

        verify(contactRepository).findByAddressPostalCode(postalCode);
    }
}