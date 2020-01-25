package com.automation.homework.api.api_test;
import com.automation.homework.api.helpers.SpecApiHelper;
import com.automation.homework.api.helpers.TestBaseApi;
import com.automation.homework.api.models.Specialty;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.core.IsNull.notNullValue;

public class SpecialtyApiTest extends TestBaseApi {
    SpecApiHelper specApiHelper=new SpecApiHelper();
    Specialty specialty;

    @Test
    public void getSpecialtiesTest()  {
        RestAssured.given()
                .get("/specialties")
                .then()
                .statusCode(200)
                .body("id", hasItems(84))
                .body("name", hasItems("Toxicology"))
                .log().all();
    }
    @Test
    public void getSpecialtiesByIdTest() {
        int specialtiesId = 84;
        RestAssured.given()
                .get("/specialties/{id}", specialtiesId)
                .then()
                .statusCode(200)
                .body("id", equalTo(specialtiesId))
                .body("name", equalTo("Toxicology"))
                .log().all();
    }
    @Test
    public void getSpecialtiesByIdWithObjectTest() {
        int specialtiesId = 84;
        Specialty specialty = RestAssured.given()
                .get("/specialties/{id}", specialtiesId)
                .then()
                .statusCode(200)
                .body("id", equalTo(specialtiesId))
                .body("name", equalTo("Toxicology"))
                .extract().body().as(Specialty.class);
        System.out.println(specialty);
    }

    @Test
    public void postSpecialtiesTestWithObject() {
        Specialty  specialtyDoctor= new Specialty();
        specialtyDoctor.setName("Doctor");
        Specialty specialty = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(specialtyDoctor)
                .post("/specialties")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("name", equalTo(specialtyDoctor.getName()))
                .log().all()
                .extract().body()

                .as(Specialty.class);


        assertThat(specialty.getId()).isNotEqualTo(0);
        assertThat(specialty.getName()).isEqualTo(specialtyDoctor.getName());
        specApiHelper.deleteSpec(specialty);
    }

    @Test
    public void deleteSpecTest() {
        Specialty specialty;
        specialty = specApiHelper.addSpecDefault();

        RestAssured.given()
                .contentType(ContentType.JSON)
                .delete("/specialties/" +specialty.getId())
                .then().statusCode(204);

    }
    @Test
    public void putSpecTest() {
        specialty = specApiHelper.addSpecDefault();
        Specialty updateSpecialty=new Specialty();

        updateSpecialty.setName("laboratory assistant");
        updateSpecialty.setId(specialty.getId());
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(updateSpecialty)
                .put("/specialties/" +updateSpecialty.getId())
                .then().statusCode(204)
                .log().all();

        //specApiHelper.getSpecialtiesByIdTest();
        specApiHelper.deleteSpec(updateSpecialty);

    }
}
