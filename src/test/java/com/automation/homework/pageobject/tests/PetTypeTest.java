package com.automation.homework.pageobject.tests;

import com.automation.homework.pageobject.TestBase;
import com.automation.homework.pageobject.pets.NewPetTypesPage;
import com.automation.homework.pageobject.pets.PetTypesObject;
import com.automation.homework.pageobject.pets.PetTypesPage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Epic("Petclinic")
@Feature("Pet type")
public class PetTypeTest extends TestBase {
    private PetTypesPage petTypesPage;
    private NewPetTypesPage newPetTypesPage;
    private PetTypesObject petTypesObject;
    private String petId="pettypes";
    private String petName="pettype_name";


    @BeforeMethod
    public void setUpBeforeTest() {
        petTypesPage = new PetTypesPage(driver);
        newPetTypesPage = new NewPetTypesPage(driver);
        petTypesObject = new PetTypesObject(driver);
    }

    @Story("Create pet type")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("1121")
    @Test(description = "Add new valid pet type ")
    public void addPetTypePositiveTest() {
        petTypesPage.openPage();
        newPetTypesPage.clickAddPetTypesButton();
        petTypesObject.setName("Test6");
        newPetTypesPage.fillPetTypes(petTypesObject);
        newPetTypesPage.clickSavePetTypesBtn();
        assertEquals(getLastItem(petId, petName).getAttribute("value"), "Test6");
    }

    @Story("Create pet type")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("1122")
    @Test(description = "Add new pet type with empty field ")
    public void addPetTypeWithEmptyFieldTest() {
        petTypesPage.openPage();
        int countBefore = petTypesPage.getListElements(petId).size();
        newPetTypesPage.clickAddPetTypesButton();
        petTypesObject.setName("");
        newPetTypesPage.fillPetTypes(petTypesObject);
        newPetTypesPage.clickSavePetTypes();
        int countAfter = petTypesPage.getListElements(petId).size();
        assertEquals(countBefore, countAfter);

    }

    @Story("Create pet type")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("1122")
    @Test(description = "Go to pet type page ")
    public void goToPetTypeTest() {
        petTypesPage.openPage();

    }


    @Story("Edit pet type")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("1122")
    @Test(description = "edit pet type ")
    public void editPetTypeTest() {
        petTypesPage.openPage();
        petTypesPage.editPetTypes();
        petTypesObject.setName("xxxx");
        newPetTypesPage.fillPetTypes(petTypesObject);
        petTypesPage.clickUpdate();
        assertEquals(getLastItem(petId, petName).getAttribute("value"), "xxxx");
    }

    @Story("Delete pet type")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("11522")
    @Test(description = "delete pet type ")
    public void deletePetTypeTest() {
        petTypesPage.openPage();
        int countBefore = petTypesPage.getListElements(petId).size();
        petTypesPage.deletePetTypes();
        int countAfter = petTypesPage.getListElements(petId).size();
        assertEquals(countBefore - 1, countAfter);
    }

    @Story("Home")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("1162")
    @Test(description = "go to home ")
    public void goHomeButtonTest() {
        petTypesPage.openPage();
        openHomePage();

    }
}
