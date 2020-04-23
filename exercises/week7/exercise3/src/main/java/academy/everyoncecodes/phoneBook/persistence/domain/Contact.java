package academy.everyoncecodes.phoneBook.persistence.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Contact {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String name;

    @OneToOne
    private Address address;

    Contact(){
    }

    public Contact(Address address) {
        this.address = address;
    }

    public Contact(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id) &&
                Objects.equals(name, contact.name) &&
                Objects.equals(address, contact.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }
}
