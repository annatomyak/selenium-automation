package com.automation.homework.api.helpers;

import com.automation.homework.api.models.OwnerApi;
import com.automation.homework.api.models.PetApi;
import com.automation.homework.api.models.Type;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

public class PetApiHelper {
    public Response createPet(PetApi petApi) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(petApi)
                .post("/pet");
    }

    public PetApi createDefaultPet() {
        List<Type> type = Arrays.asList(RestAssured.given()
                .contentType(ContentType.JSON)
                .get("/pettypes")
                .then()
                .statusCode(200)
                .extract().body()
                .as(Type[].class));

        PetApi petApi = new PetApi();
        petApi.setName("Murka");
        petApi.setBirthDate("2020/01/05");
        petApi.setType(type.get(0));
        OwnerApi owner=new OwnerApi();
        petApi.setOwner(owner);
        return createPet(petApi).then().statusCode(201)
                .extract().body().as(PetApi.class);
    }

    public void deletePet(PetApi petApi) {
        if (petApi != null) {
            deletePet(petApi.getId());
        }
    }

    public void deletePet(int id) {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .delete("/pets/" + id)
                .then().statusCode(204);

    }
}
