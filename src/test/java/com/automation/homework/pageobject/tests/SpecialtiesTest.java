package com.automation.homework.pageobject.tests;
import com.automation.homework.pageobject.TestBase;
import com.automation.homework.pageobject.specialities.EditSpecialties;
import com.automation.homework.pageobject.specialities.NewSpecialtiesPage;
import com.automation.homework.pageobject.specialities.SpecialtiesObject;
import com.automation.homework.pageobject.specialities.SpecialtiesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SpecialtiesTest extends TestBase {


    private SpecialtiesPage specialtiesPage;
    private NewSpecialtiesPage newSpecialtiesPage;
    private SpecialtiesObject specialtiesObject;
    private EditSpecialties editSpecialties;


    @BeforeMethod
    public void setUpBeforeTest() {
        specialtiesPage = new SpecialtiesPage(driver);
        newSpecialtiesPage = new NewSpecialtiesPage(driver);
        specialtiesObject = new SpecialtiesObject(driver);
        editSpecialties = new EditSpecialties(driver);
    }

    @Test
    public void addSpecialtiesPositiveTest() {
        specialtiesPage.openPage();
        newSpecialtiesPage.clickAddSpecialityButton();
        specialtiesObject.setName("TestAnna");
        newSpecialtiesPage.fillSpecialties(specialtiesObject);
        newSpecialtiesPage.clickSaveSpecialityBtn();
        assertEquals(getLastItem("specialties", "spec_name").getAttribute("value"), "TestAnna");
    }

    @Test
    public void goToSpecialtiesTest() {
        specialtiesPage.openPage();

    }

    @Test
    public void addSpecialtiesEmptyFieldTest() {
        specialtiesPage.openPage();
        int countBefore = specialtiesPage.getListElements("specialties").size();
        newSpecialtiesPage.clickAddSpecialityButton();
        specialtiesObject.setName("");
        newSpecialtiesPage.fillSpecialties(specialtiesObject);
        newSpecialtiesPage.clickSaveSpeciality();
        int countAfter = specialtiesPage.getListElements("specialties").size();
        assertEquals(countBefore, countAfter);
    }

    @Test
    public void editSpecialtiesTest() {
        specialtiesPage.openPage();
        specialtiesPage.editSpecialties();
        specialtiesObject.setName("test5");
        newSpecialtiesPage.fillSpecialties(specialtiesObject);
        editSpecialties.clickUpdate();
        assertEquals(getLastItem("specialties", "spec_name").getAttribute("value"), "test5");
        ;
    }

    @Test
    public void deleteSpecialtiesTest() {
        specialtiesPage.openPage();
        int countBefore = editSpecialties.getListElements("specialties").size();
        editSpecialties.deleteSpecialties();
        int countAfter = editSpecialties.getListElements("specialties").size();
        assertEquals(countBefore - 1, countAfter);
    }

    @Test
    public void goHomeButtonTest() {
        specialtiesPage.openPage();
        openHomePage();

    }
}



