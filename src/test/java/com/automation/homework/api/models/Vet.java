package com.automation.homework.api.models;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class Vet {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("specialties")
    private List<Specialty> specialties;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("specialties")
    public List<Specialty> getSpecialties() {
        return specialties;
    }

    @JsonProperty("specialties")
    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }

    @Override
    public String toString() {
        return "Vet{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialties=" + specialties +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vet)) return false;
        Vet vet = (Vet) o;
        return Objects.equals(getId(), vet.getId()) &&
                Objects.equals(getFirstName(), vet.getFirstName()) &&
                Objects.equals(getLastName(), vet.getLastName()) &&
                Objects.equals(getSpecialties(), vet.getSpecialties());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getSpecialties());
    }
}
