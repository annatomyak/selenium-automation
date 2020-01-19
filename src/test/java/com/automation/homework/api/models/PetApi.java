package com.automation.homework.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PetApi {
    @JsonProperty("birthDate")
    private String birthDate;
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private OwnerApi owner;
    @JsonProperty("type")
    private Type type;
    @JsonProperty("visits")
    private List<Visit> visits = null;

    public PetApi() {
    }

    public PetApi(String name, String birthDate, String type) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public PetApi(int id, String name, String birthDate, String type) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OwnerApi getOwner() {
        return owner;
    }

    public void setOwner(OwnerApi owner) {
        this.owner = owner;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
