package com.automation.homework.api.helpers;
import com.automation.homework.api.models.Specialty;
import com.automation.homework.api.models.Type;
import io.restassured.RestAssured;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VetApiHelper {
    public List<Specialty> getSpecialties()  {
        List<Specialty> specialtyList= Arrays.asList( RestAssured.given()
                .get("/specialties")
                .then()
                .statusCode(200)
                .log().all()
        .extract().body().as(Specialty[].class));
   return specialtyList;
    }
}
