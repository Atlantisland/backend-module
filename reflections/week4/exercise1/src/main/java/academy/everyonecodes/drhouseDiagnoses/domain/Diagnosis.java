package academy.everyonecodes.drhouseDiagnoses.domain;

import java.util.Objects;

public class Diagnosis {

    private String name;
    private String symptoms;

    public Diagnosis() {
    }

    public Diagnosis(String name, String symptoms) {
        this.name = name;
        this.symptoms = symptoms;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnosis diagnosis = (Diagnosis) o;
        return Objects.equals(name, diagnosis.name) &&
                Objects.equals(symptoms, diagnosis.symptoms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, symptoms);
    }
}
