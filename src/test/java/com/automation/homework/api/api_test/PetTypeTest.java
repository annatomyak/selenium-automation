package com.automation.homework.api.api_test;

import com.automation.homework.api.helpers.TestBaseApi;
import com.automation.homework.api.models.PetApi;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.core.IsNull.notNullValue;

public class PetTypeTest extends TestBaseApi {


    @Test
    public void getPetTypeTest() {
        RestAssured.given()
                .get("/pettypes")
                .then()
                .statusCode(200)
                .body("id", hasItems(48, 92))
                .body("name", hasItems("cat", "dragon"))
                .log().all();
    }

    @Test
    public void getPetTypeByIdTest() {
        int petId = 92;
        RestAssured.given()
                .get("/pettypes/{id}", petId)
                .then()
                .statusCode(200)
                .body("id", equalTo( petId))
                .body("name", equalTo("cat"))
                .log().all();
    }

    @Test
    public void getPetTypeByIdWithObjectTest() {
        int petId = 92;
        PetApi pet = RestAssured.given()
                .get("/pettypes/{id}", petId)
                .then()
                .statusCode(200)
                .body("id", equalTo(petId))
                .body("name", equalTo("cat"))
                .extract().body().as(PetApi.class);
        System.out.println(pet);
    }

    @Test
    public void postPetTypeTest() {
        String petType = "hamster";
        ResponseBodyExtractionOptions body = RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"name\":\"" + petType + "\"\n" +
                        "}")
                .post("/pettypes")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("name", equalTo(petType))
                .extract().body();

        int id = body.jsonPath().getInt("id");
        String name = body.jsonPath().getString("name");
        System.out.println();

    }

    @Test
    public void postPetTypeTestWithObject() {
        PetApi squirrelPet = new PetApi();
        squirrelPet.setName("hamster");
        PetApi pet = RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(squirrelPet)
                .post("/pettypes")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("name", equalTo(squirrelPet.getName()))
                .extract().body()
                .as(PetApi.class);

        assertThat(pet.getId()).isNotEqualTo(0);
        assertThat(pet.getName()).isEqualTo(squirrelPet.getName());
    }

    @Test
    public void deletePetTypeByIdTest() {
        int petId = 118;
        RestAssured.given()
                .log().all()
                .delete("/pettypes/{id}", petId)
                .then()
                .statusCode(204);
    }

    }

