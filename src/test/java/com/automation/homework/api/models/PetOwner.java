package com.automation.homework.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PetOwner {
    @JsonProperty("birthDate")
    private String birthDate;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private OwnerApi owner;
    @JsonProperty("type")
    private Type type;
    @JsonProperty("visits")
    private List<Visit> visits = null;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OwnerApi getOwner() {
        return owner;
    }

    public void setOwner(OwnerApi owner) {
        this.owner = owner;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }
}
