package academy.everyoncecodes.phoneBook.communication;

import academy.everyoncecodes.phoneBook.logic.PhoneBookService;
import academy.everyoncecodes.phoneBook.persistence.domain.Contact;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactEndpoint {

    private final PhoneBookService phoneBookService;

    public ContactEndpoint(PhoneBookService phoneBookService) {
        this.phoneBookService = phoneBookService;
    }

    @GetMapping
    List<Contact> get(){
        return phoneBookService.findAll();
    }

    @PostMapping
    Contact post(@Valid @RequestBody Contact contact){
        return phoneBookService.save(contact);
    }

    @GetMapping("/postalcodes/{postalCode}")
    List<Contact> get(@PathVariable String postalCode){
        return phoneBookService.findByAddressPostalCode(postalCode);
    }
}
