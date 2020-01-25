package com.automation.homework.pageobject.tests;
import com.automation.homework.listener.MyCustomListener;
import com.automation.homework.pageobject.TestBase;
import com.automation.homework.pageobject.vets.NewVeterinarians;
import com.automation.homework.pageobject.vets.VeterinarianObject;
import com.automation.homework.pageobject.vets.VeterinariansPage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;


@Epic("Petclinic")
@Feature("Veterinarians")
@Listeners({MyCustomListener.class})
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

    @Story("Create Veterinarians")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("12691")
    @Test(description = "Add new valid veterinarians ")
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
    @Story("Create Veterinarians")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("12691")
    @Test(description = "Add new veterinarian with one letter in first name ")
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
    @Story("Create Veterinarians")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("12691")
    @Test(description = "Add new veterinarian with one letter in last name ")
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


    @Story("Create Veterinarians")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("691")
    @Test(description = "Add new veterinarian with empty in first name ")
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

    @Story("Create Veterinarians")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("692")
    @Test(description = "Add new veterinarian with empty in last name ")
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
