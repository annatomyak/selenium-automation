package com.automation.homework.api.api_test;

import com.automation.homework.api.helpers.TestBaseApi;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class OwnerTest extends TestBaseApi {


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
}