package com.automation.homework.api.helpers;
import com.automation.homework.api.models.Specialty;
import io.restassured.RestAssured;

import java.util.ArrayList;

public class VetApiHelper {
    public VetApiHelper getSpecialties()  {

         RestAssured.given()
                .get("/specialties")
                .then()
                .statusCode(200)
                .log().all();
   return new VetApiHelper();
    }
}
