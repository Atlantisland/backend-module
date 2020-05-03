package academy.everyoncecodes.phoneBook.communication;

import academy.everyoncecodes.phoneBook.logic.PhoneBookService;
import academy.everyoncecodes.phoneBook.persistence.domain.Contact;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactEndpoint {

    private final PhoneBookService service;

    public ContactEndpoint(PhoneBookService service) {
        this.service = service;
    }

    @PostMapping
    Contact save(@Valid @RequestBody Contact contact){
        return service.save(contact);
    }

    @GetMapping
    List<Contact> findAll(){
        return service.findAll();
    }

    @GetMapping("/postalCodes/{postalCode}")
    List<Contact> findContactsByPostalCode(@PathVariable String postalCode){
        return service.findByAddressPostalCode(postalCode);
    }
}
