package academy.everyoncecodes.phoneBook.logic;

import academy.everyoncecodes.phoneBook.persistence.domain.Contact;
import academy.everyoncecodes.phoneBook.persistence.repository.AddressRepository;
import academy.everyoncecodes.phoneBook.persistence.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneBookService {

    private final AddressRepository addressRepository;
    private final ContactRepository contactRepository;

    public PhoneBookService(AddressRepository addressRepository, ContactRepository contactRepository) {
        this.addressRepository = addressRepository;
        this.contactRepository = contactRepository;
    }

    public Contact save(Contact contact){
        addressRepository.save(contact.getAddress());
        return contactRepository.save(contact);
    }

    public List<Contact> findAll(){
        return contactRepository.findAll();
    }

    public List<Contact> findByAddressPostalCode(String postalCode){
        return contactRepository.findContactByAddressPostalCode(postalCode);
    }
}
