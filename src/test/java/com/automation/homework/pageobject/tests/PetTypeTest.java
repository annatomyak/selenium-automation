package com.automation.homework.pageobject.tests;

import com.automation.homework.pageobject.TestBase;
import com.automation.homework.pageobject.pets.NewPetTypesPage;
import com.automation.homework.pageobject.pets.PetTypesObject;
import com.automation.homework.pageobject.pets.PetTypesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


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

    @Test
    public void addPetTypePositiveTest() {
        petTypesPage.openPage();
        newPetTypesPage.clickAddPetTypesButton();
        petTypesObject.setName("Test6");
        newPetTypesPage.fillPetTypes(petTypesObject);
        newPetTypesPage.clickSavePetTypesBtn();
        assertEquals(getLastItem(petId, petName).getAttribute("value"), "Test6");
    }

    @Test
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

    @Test
    public void goToPetTypeTest() {
        petTypesPage.openPage();

    }


    @Test
    public void editPetTypeTest() {
        petTypesPage.openPage();
        petTypesPage.editPetTypes();
        petTypesObject.setName("xxxx");
        newPetTypesPage.fillPetTypes(petTypesObject);
        petTypesPage.clickUpdate();
        assertEquals(getLastItem(petId, petName).getAttribute("value"), "xxxx");
    }

    @Test
    public void deletePetTypeTest() {
        petTypesPage.openPage();
        int countBefore = petTypesPage.getListElements(petId).size();
        petTypesPage.deletePetTypes();
        int countAfter = petTypesPage.getListElements(petId).size();
        assertEquals(countBefore - 1, countAfter);
    }

    @Test
    public void goHomeButtonTest() {
        petTypesPage.openPage();
        openHomePage();

    }
}
