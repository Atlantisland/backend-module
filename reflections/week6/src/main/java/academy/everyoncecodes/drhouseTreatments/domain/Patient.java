package academy.everyoncecodes.drhouseTreatments.domain;

import java.util.Objects;

public class Patient {

    private String uuid;
    private String name;
    private String symptoms;
    private String diagnosis;
    private String treatment;

    public Patient() {
    }

    public Patient(String uuid, String name, String symptoms, String diagnosis, String treatment) {
        this.uuid = uuid;
        this.name = name;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public Patient(String treatment) {
       this.treatment = treatment;
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

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(uuid, patient.uuid) &&
                Objects.equals(name, patient.name) &&
                Objects.equals(symptoms, patient.symptoms) &&
                Objects.equals(diagnosis, patient.diagnosis) &&
                Objects.equals(treatment, patient.treatment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, symptoms, diagnosis, treatment);
    }
}
