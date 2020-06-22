package academy.everyoncecodes.phoneBook.logic;

import academy.everyoncecodes.phoneBook.persistence.domain.Contact;
import academy.everyoncecodes.phoneBook.persistence.repository.AddressRepository;
import academy.everyoncecodes.phoneBook.persistence.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneBookService {

    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;

    public PhoneBookService(ContactRepository contactRepository, AddressRepository addressRepository) {
        this.contactRepository = contactRepository;
        this.addressRepository = addressRepository;
    }

    public List<Contact> findAll(){
        return contactRepository.findAll();
    }

    public Contact save(Contact contact){
        addressRepository.save(contact.getAddress());
        return contactRepository.save(contact);
    }

    public List<Contact> findByAddressPostalCode(String postalCode){
       return contactRepository.findByAddressPostalCode(postalCode);
    }
}
