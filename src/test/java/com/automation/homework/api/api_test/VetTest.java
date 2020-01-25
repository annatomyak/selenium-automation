package com.automation.homework.api.api_test;

import com.automation.homework.api.helpers.TestBaseApi;
import com.automation.homework.api.helpers.VetApiHelper;
import com.automation.homework.api.models.OwnerApi;
import com.automation.homework.api.models.Specialty;
import com.automation.homework.api.models.Vet;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;

public class VetTest extends TestBaseApi {
    Vet vet=new Vet();


    @Test
    public void createVetTest() {
        vet.setFirstName("Pablo");
        vet.setLastName("Esscobar");
        vet = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(vet)
                .post("/vets")
                .then()
                .statusCode(201)
                .extract().body()
                .as(Vet.class);

    }
    @Test
    public void getVetByIdTest() {
        RestAssured.given()
                .get("/vets/{id}", vet.getId())
                .then()
                .statusCode(200)
                .body("id", equalTo(vet.getId()))
                .body("firstName", equalTo(vet.getFirstName()))
                .body("lastName", equalTo(vet.getLastName()))
                .log().all();
    }


    private Vet postVetTestWithObject() {
        Vet vet = new Vet();
        vet.setFirstName("testFirstNameApi");
        vet.setLastName("testLastNameApi");

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(vet)
                .log().all()
                .post("/vets")
                .then()
                .log().all()
                .statusCode(201)
                .extract().body()
                .as(Vet.class);
    }

    public void deleteVetByIdTest(int id) {
        RestAssured.given()
                .log().all()
                .delete("/vets/{id}", id)
                .then()
                .statusCode(204);
    }

    private void putVetTestWithObject() {
        vet.setFirstName("Toxy");
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(vet)
                .log().all()
                .put("/vets/{id}", vet.getId())
                .then()
                .log().all()
                .statusCode(204);
    }

    @Test
    public void getVetByIdAfterPutTest() {
        putVetTestWithObject();
        getVetByIdTest();
    }
}
