package com.automation.homework.api.api_test;
import com.automation.homework.api.helpers.TestBaseApi;
import com.automation.homework.api.helpers.VetApiHelper;
import com.automation.homework.api.models.Specialty;
import com.automation.homework.api.models.Vet;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

public class VetTest extends TestBaseApi {
    Vet vet = new Vet();
    VetApiHelper vetApiHelper = new VetApiHelper();
    List<Specialty> specialtyList = vetApiHelper.getSpecialties();
    @Test
    public void createVetTest() {
        vet.setFirstName("Pablo");
        vet.setLastName("Esscobar");
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(vet)
                .post("/vets")
                .then()
                .log().all()
                .statusCode(201)
                .extract().body()
                .as(Vet.class);

    }

    @Test
    public void getVetByIdTest() {
        int vetId = 1;
        RestAssured.given()
                .get("/vets/{id}", vetId)
                .then()
                .statusCode(200)
                .body("id", equalTo(vetId))
                .body("firstName", equalTo("James"))
                .body("lastName", equalTo("Carter"))
                .log().all();
    }

    @Test
    public void postVetTestWithObjectWithoutSpec(){
        vet.setFirstName("Anna");
        vet.setLastName("Tomyak");

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(vet)
                .post("/vets")
                .then()
                .log().all()
                .statusCode(201);
//                .extract().body()
//                .as(Vet.class);

    }

    @Test
    public void deleteVetByIdTest(int id) {
        id=7;
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
