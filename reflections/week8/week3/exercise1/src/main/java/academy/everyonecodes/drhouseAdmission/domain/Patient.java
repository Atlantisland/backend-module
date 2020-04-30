package academy.everyonecodes.drhouseAdmission.domain;

import java.util.Objects;

public class Patient {

    private String uuid;
    private String name;
    private String symptoms;

    Patient() {
    }

    public Patient(String name, String symptoms) {
        this.name = name;
        this.symptoms = symptoms;
    }

    public Patient(String uuid, String name, String symptoms) {
        this.uuid = uuid;
        this.name = name;
        this.symptoms = symptoms;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(getUuid(), patient.getUuid()) &&
                Objects.equals(getName(), patient.getName()) &&
                Objects.equals(getSymptoms(), patient.getSymptoms());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getName(), getSymptoms());
    }
}
