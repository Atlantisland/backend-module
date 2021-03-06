package academy.everyoncecodes.phoneBook.communication;

import academy.everyoncecodes.phoneBook.logic.PhoneBookService;
import academy.everyoncecodes.phoneBook.persistence.domain.Address;
import academy.everyoncecodes.phoneBook.persistence.domain.Contact;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContactEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    PhoneBookService service;

    String url = "/contacts";

    @Test
    void save(){
        Address address = new Address("street", "1234");
        Contact contact = new Contact("name", address);

        testRestTemplate.postForObject(url, contact, Contact.class);

        verify(service).save(contact);
    }

    @Test
    void findAll(){
        testRestTemplate.getForObject(url, Contact[].class);
        verify(service).findAll();
    }

    @Test
    void findContactsByPostalCode(){
        String postalCode = "1234";
        String postalCodeUrl = url + "/postalcodes/" + postalCode;

        testRestTemplate.getForObject(postalCodeUrl, Contact[].class);

        verify(service).findByAddressPostalCode(postalCode);
    }
}