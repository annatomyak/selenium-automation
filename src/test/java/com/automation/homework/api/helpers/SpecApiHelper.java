package com.automation.homework.api.helpers;

import com.automation.homework.api.models.OwnerApi;
import com.automation.homework.api.models.Specialty;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class SpecApiHelper extends Specialty {

    public Specialty addSpecDefault() {
        Specialty  specialtyDoctor= new Specialty();
        specialtyDoctor.setName("Toxic");
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(specialtyDoctor)
                .post("/specialties")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("name", equalTo(specialtyDoctor.getName()))
                .log().all()
                .extract().body()
                .as(Specialty.class);


    }


    public void deleteSpec(Specialty specialty) {
        if (specialty != null) {
            deleteSpec(specialty.getId());
        }
    }

    public void deleteSpec(int id) {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .delete("/specialties/" + id)
                .then().statusCode(204);

    }
    public Specialty getSpecialtiesByIdTest() {
        Specialty  specialty= new Specialty();
        return (Specialty) RestAssured.given()
                .get("/specialties/{id}",specialty.getId())
                .then()
                .statusCode(200)
                .body("id", equalTo(specialty.getId()))
                .body("name", equalTo(specialty.getName()))
                .log().all();

    }
    }

