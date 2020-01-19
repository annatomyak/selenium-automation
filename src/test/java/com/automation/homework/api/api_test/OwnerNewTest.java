package com.automation.homework.api.api_test;

import com.automation.homework.api.helpers.TestBaseApi;
import com.automation.homework.api.models.OwnerApi;
import com.automation.homework.api.models.PetApi;
import com.automation.homework.api.models.Type;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OwnerNewTest extends TestBaseApi {
    private OwnerApi owner;
    private Type type;


    @AfterMethod
    public void cleanData() {
        if (owner != null) {
            RestAssured.given()
                    .contentType(ContentType.JSON)
                    .delete("/owners/" + owner.getId())
                    .then()
                    .statusCode(204);
        }

        if (type != null) {
            RestAssured.given()
                    .contentType(ContentType.JSON)
                    .delete("/pettypes/" + type.getId())
                    .then()
                    .statusCode(204);
        }
    }


    @Test
    public void postPetTypeTest() throws JsonProcessingException {
        owner = new OwnerApi();
        owner.setFirstName("Anna");
        owner.setLastName("Esscobar");
        owner.setAddress("Columbia, st 45");
        owner.setCity("Medelin");
        owner.setTelephone("1234567890");

        owner = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(owner)
                .post("/owners")
                .then()
                .statusCode(201)
                .extract().body()
                .as(OwnerApi.class);

        type = new Type();
        type.setName("Piton");

        type = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(type)
                .post("/pettypes")
                .then()
                .statusCode(201)
                .extract().body()
                .as(Type.class);


        PetApi pet = new PetApi();
        pet.setName("Bob");
        pet.setType(type);
        pet.setBirthDate("2020/01/09");
        pet.setOwner(owner);

        pet = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet)
                .post("/pets")
                .then()
                .statusCode(201)
                .extract().body()
                .as(PetApi.class);


        System.out.println(owner);
    }


    @Test
    public void postPetTypeTest2() {
        owner = new OwnerApi();
        owner.setFirstName("Pablo");
        owner.setLastName("Esscobar");
        owner.setAddress("Columbia, st 45");
        owner.setCity("Medelin");
        owner.setTelephone("1234567890");

        owner = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(owner)
                .post("/owners")
                .then()
                .statusCode(201)
                .extract().body()
                .as(OwnerApi.class);

        List<Type> type = Arrays.asList(RestAssured.given()
                .contentType(ContentType.JSON)
                .get("/pettypes")
                .then()
                .statusCode(200)
                .extract().body()
                .as(Type[].class));

        PetApi pet = new PetApi();
        pet.setName("Bob");
        pet.setType(type.get(0));
        pet.setBirthDate("2020/01/09");
        pet.setOwner(owner);

        pet = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet)
                .post("/pets")
                .then()
                .statusCode(201)
                .extract().body()
                .as(PetApi.class);


        System.out.println(owner);
    }

    @Test
    public void createOwnerTest() {
        owner = new OwnerApi();
        owner.setFirstName("Pablo");
        owner.setLastName("Esscobar");
        owner.setAddress("Columbia, st 45");
        owner.setCity("Medelin");
        owner.setTelephone("1234567890");

        owner = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(owner)
                .post("/owners")
                .then()
                .statusCode(201)
                .extract().body()
                .as(OwnerApi.class);

        OwnerApi actualOwner = RestAssured.given()
                .contentType(ContentType.JSON)
                .get("/owners/" + owner.getId())
                .then()
                .statusCode(200)
                .extract().body()
                .as(OwnerApi.class);

        assertThat(actualOwner).isEqualTo(owner);
    }
}
