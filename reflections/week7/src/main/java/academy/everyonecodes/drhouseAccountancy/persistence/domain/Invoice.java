package academy.everyonecodes.drhouseAccountancy.persistence.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    private double cost;
    private boolean paid;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    public Invoice() {
    }

    public Invoice(double cost, boolean paid, Patient patient) {
        this.cost = cost;
        this.paid = paid;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Double.compare(invoice.cost, cost) == 0 &&
                paid == invoice.paid &&
                Objects.equals(id, invoice.id) &&
                Objects.equals(patient, invoice.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cost, paid, patient);
    }
}
