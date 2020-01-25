package com.automation.homework.api.helpers;

import com.automation.homework.api.models.OwnerApi;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OwnerApiHelper {
    public Response createOwner(OwnerApi owner) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(owner)
                .post("/owners");
    }

    public OwnerApi createDefaultOwner() {
        OwnerApi owner = new OwnerApi();
        owner.setFirstName("Pablo");
        owner.setLastName("Esscobar");
        owner.setAddress("Columbia, st 45");
        owner.setCity("Medelin");
        owner.setTelephone("1234567890");
        return createOwner(owner).then().statusCode(201)
                .extract().body().as(OwnerApi.class);
    }

    public void deleteOwner(OwnerApi owner) {
        if (owner != null) {
            deleteOwner(owner.getId());
        }
    }

    public void deleteOwner(int id) {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .delete("/owners/" + id)
                .then().statusCode(204);

    }
}
