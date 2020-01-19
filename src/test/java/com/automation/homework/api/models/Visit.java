package com.automation.homework.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Visit {
    @JsonProperty("date")
    private String date;
    @JsonProperty("description")
    private String description;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("pet")
    private PetApi pet;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PetApi getPet() {
        return pet;
    }

    public void setPet(PetApi pet) {
        this.pet = pet;
    }
}
