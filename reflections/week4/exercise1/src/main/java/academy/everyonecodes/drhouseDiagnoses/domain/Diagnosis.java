package academy.everyonecodes.drhouseDiagnoses.domain;

import java.util.Objects;

public class Diagnosis {

    private String name;
    private String symptoms;

    Diagnosis() {
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
}
