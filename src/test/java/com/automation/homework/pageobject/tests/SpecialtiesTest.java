package com.automation.homework.pageobject.tests;
import com.automation.homework.pageobject.TestBase;
import com.automation.homework.pageobject.specialities.EditSpecialties;
import com.automation.homework.pageobject.specialities.NewSpecialtiesPage;
import com.automation.homework.pageobject.specialities.SpecialtiesObject;
import com.automation.homework.pageobject.specialities.SpecialtiesPage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
@Epic("Petclinic")
@Feature("Specialties")
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

    @Story("Create specialties")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("11241")
    @Test(description = "Add new valid specialties ")
    public void addSpecialtiesPositiveTest() {
        specialtiesPage.openPage();
        newSpecialtiesPage.clickAddSpecialityButton();
        specialtiesObject.setName("TestAnna");
        newSpecialtiesPage.fillSpecialties(specialtiesObject);
        newSpecialtiesPage.clickSaveSpecialityBtn();
        assertEquals(getLastItem("specialties", "spec_name").getAttribute("value"), "TestAnna");
    }

    @Story("Create specialties")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("11241")
    @Test(description = "Go to specialties ")
    public void goToSpecialtiesTest() {
        specialtiesPage.openPage();

    }

    @Story("Create specialties")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("11241")
    @Test(description = "Add specialties with empty field ")
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

    @Story("Edit specialties")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("5241")
    @Test(description = "Edit specialties  ")
    public void editSpecialtiesTest() {
        specialtiesPage.openPage();
        specialtiesPage.editSpecialties();
        specialtiesObject.setName("test5");
        newSpecialtiesPage.fillSpecialties(specialtiesObject);
        editSpecialties.clickUpdate();
        assertEquals(getLastItem("specialties", "spec_name").getAttribute("value"), "test5");
        ;
    }

    @Story("Delete specialties")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("51241")
    @Test(description = "Delete specialties  ")
    public void deleteSpecialtiesTest() {
        specialtiesPage.openPage();
        int countBefore = editSpecialties.getListElements("specialties").size();
        editSpecialties.deleteSpecialties();
        int countAfter = editSpecialties.getListElements("specialties").size();
        assertEquals(countBefore - 1, countAfter);
    }

    @Story("Home")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("11241")
    @Test(description = "Go home")
    public void goHomeButtonTest() {
        specialtiesPage.openPage();
        openHomePage();

    }
}



