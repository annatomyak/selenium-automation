package com.automation.homework.api;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.core.IsNull.notNullValue;

public class PetTypeTest {
    @BeforeClass
    public void setUp(){
        RestAssured.baseURI="http://139.59.149.247:9966/petclinic/api";
        RestAssured.defaultParser= Parser.JSON;
    }

    @Test
    public  void getPetTypeTest(){
        RestAssured.given()
                .accept(ContentType.JSON)
                .baseUri("http://139.59.149.247:9966/petclinic/api")
                .get("/pettypes")
                .then().statusCode(200)
                .body("id",hasItems(48,92))
                .body("name",hasItems("cat"))
                .log().all();

    }
    @Test
    public  void getPetTypeByIdTest(){
        RestAssured.given()
                .accept(ContentType.JSON)
                .baseUri("http://139.59.149.247:9966/petclinic/api")
                .get("/pettypes/"+92)
                .then().statusCode(200)
                .body("id",equalTo(92))
                .body("name",equalTo("cat"))
                .log().all();

    }
    @Test
    public  void postPetTypeTest(){
        RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .baseUri("http://139.59.149.247:9966/petclinic/api")
                .body("{\n" +
                        "  \n" +
                        "  \"name\": \"cat\"\n" +
                        "}")
                .post("/pettypes")
                .then()
                .statusCode(201)
                .body("id",notNullValue())
                .body("name",equalTo("cat"));
}

    }

