package com.automation.homework.api.models;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class Vet {

    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("specialties")
    private List<Specialty> specialties = null;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vet{" +
                "firstName='" + firstName + '\'' +
                ", id=" + id +
                ", lastName='" + lastName + '\'' +
                ", specialties=" + specialties +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vet)) return false;
        Vet vet = (Vet) o;
        return Objects.equals(getFirstName(), vet.getFirstName()) &&
                Objects.equals(id, vet.id) &&
                Objects.equals(getLastName(), vet.getLastName()) &&
                Objects.equals(getSpecialties(), vet.getSpecialties());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), id, getLastName(), getSpecialties());
    }
}
