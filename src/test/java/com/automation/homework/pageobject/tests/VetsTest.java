package com.automation.homework.pageobject.tests;
import com.automation.homework.pageobject.TestBase;
import com.automation.homework.pageobject.vets.NewVeterinarians;
import com.automation.homework.pageobject.vets.VeterinarianObject;
import com.automation.homework.pageobject.vets.VeterinariansPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

public class VetsTest extends TestBase {
    private VeterinariansPage veterinariansPage;
    private VeterinarianObject veterinarianObject;
    private NewVeterinarians newVeterinarians;

    @BeforeMethod
    public void setUpBeforeTest() {
        veterinariansPage=new VeterinariansPage(driver);
        veterinarianObject=new VeterinarianObject(driver);
        newVeterinarians=new NewVeterinarians(driver);
    }

    @Test
    public void addVetsPositiveTest(){
        veterinariansPage.openPage();
        veterinariansPage.clickAddVetBtn();
        veterinarianObject.setFirstName("Anna");
        veterinarianObject.setLastName("Tomyak");
        veterinarianObject.setType("Anna");
        newVeterinarians.fillVet(veterinarianObject);
        newVeterinarians.clickAddVetButton();
        List<VeterinarianObject> vetNames = veterinariansPage.getVetsList();
        assertThat(vetNames).contains(veterinarianObject);


    }
    @Test
    public void addNewVetsWithOneLetterInNameTest() {

        veterinariansPage.openPage();
        veterinariansPage.clickAddVetBtn();
        veterinarianObject.setFirstName("A");
        veterinarianObject.setLastName("Tomyak");
        veterinarianObject.setType("Anna");
        newVeterinarians.fillVet(veterinarianObject);
        newVeterinarians.clickAddVetButton();
        assertEquals(newVeterinarians.errorOneLetterinName(), "First name must be at least 2 characters long");
    }
    @Test
    public void addNewVetsWithOneLetterInLastNameTest() {

        veterinariansPage.openPage();
        veterinariansPage.clickAddVetBtn();
        veterinarianObject.setFirstName("Anna");
        veterinarianObject.setLastName("T");
        veterinarianObject.setType("Anna");
        newVeterinarians.fillVet(veterinarianObject);
        newVeterinarians.clickAddVetButton();
        assertEquals(newVeterinarians.errorOneLetterinName(), "Last name must be at least 2 characters long");
    }





    @Test
    public void addNewVetWithEmptyInFirstNameTest() {

        veterinariansPage.openPage();
        veterinariansPage.clickAddVetBtn();
        veterinarianObject.setFirstName("A");
        veterinarianObject.setLastName("Tom");
        veterinarianObject.setType("Anna");
        newVeterinarians.fillVet(veterinarianObject);
        clearField(newVeterinarians.firstNameField);
        newVeterinarians.clickAddVetButton();
        assertEquals(newVeterinarians.errorEmptyFild(), "First name is required");


    }

    @Test
    public void addNewVetWithEmptyInLastNameTest() {

        veterinariansPage.openPage();
        veterinariansPage.clickAddVetBtn();
        veterinarianObject.setFirstName("Anna");
        veterinarianObject.setLastName("T");
        veterinarianObject.setType("Anna");
        newVeterinarians.fillVet(veterinarianObject);
        clearField(newVeterinarians.lastNameField);
        newVeterinarians.clickAddVetButton();
        assertEquals(newVeterinarians.errorEmptyFild(), "Last name is required");


    }


}
