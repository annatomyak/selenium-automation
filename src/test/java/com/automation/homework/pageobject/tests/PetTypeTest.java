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
        petTypesObject.setName("Test5");
        newPetTypesPage.fillPetTypes(petTypesObject);
        newPetTypesPage.clickSavePetTypesBtn();
        assertEquals(getLastItem("pettypes", "pettype_name").getAttribute("value"), "Test5");
    }

    @Test
    public void addPetTypeWithEmptyFieldTest() {
        petTypesPage.openPage();
        int countBefore = petTypesPage.getListElements("pettypes").size();
        newPetTypesPage.clickAddPetTypesButton();
        petTypesObject.setName("");
        newPetTypesPage.fillPetTypes(petTypesObject);
        newPetTypesPage.clickSavePetTypes();
        int countAfter = petTypesPage.getListElements("pettypes").size();
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
        assertEquals(getLastItem("pettypes", "pettype_name").getAttribute("value"), "xxxx");
    }

    @Test
    public void deletePetTypeTest() {
        petTypesPage.openPage();
        int countBefore = petTypesPage.getListElements("pettypes").size();
        petTypesPage.deletePetTypes();
        int countAfter = petTypesPage.getListElements("pettypes").size();
        assertEquals(countBefore - 1, countAfter);
    }

    @Test
    public void goHomeButtonTest() {
        petTypesPage.openPage();
        petTypesPage.openHomePage();

    }
}
