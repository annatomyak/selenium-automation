package com.automation.homework.pageobject.tests;
import com.automation.homework.pageobject.TestBase;
import com.automation.homework.pageobject.owners.NewOwnerPage;
import com.automation.homework.pageobject.owners.Owner;
import com.automation.homework.pageobject.owners.OwnersPage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

@Epic("Petclinic")
@Feature("Owner")
public class NewOwnerTest extends TestBase {
    private OwnersPage ownersPage;
    private Owner owner;
    private NewOwnerPage newOwnerPage;

    @BeforeMethod
    public void setUpBeforeTest() {
        ownersPage = new OwnersPage(driver);
        owner = new Owner(driver);
        newOwnerPage = new NewOwnerPage(driver);

    }
    @Story("Create Owner")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("1111")
    @Test(description = "Add new valid Owner test")
    public void addNewOwnerTest() {

        ownersPage.openPage();
        owner.setFirstName("Bob");
        owner.setLastName("Witcher");
        owner.setAddress("street");
        owner.setCity("Rivia");
        owner.setTelephone("1818184284");
        newOwnerPage = ownersPage.clickAddOwnerBtn();
        newOwnerPage.fillOwner(owner);
        ownersPage = newOwnerPage.clickAddOwnerButton();
        List<Owner> ownersNames = ownersPage.getOwnersList();
        assertThat(ownersNames).contains(owner);


    }
//    @Story("Create Owner")
//    @Severity(SeverityLevel.MINOR)
//    @TmsLink("1112")
//    @Test(description="Add new owner with one letter in name ")
//    public void addNewOwnerWithOneLetterInNameTest() {
//
//        ownersPage.openPage();
//        owner.setFirstName("B");
//        owner.setLastName("Witcher");
//        owner.setAddress("street");
//        owner.setCity("Rivia");
//        owner.setTelephone("1818184284");
//        newOwnerPage = ownersPage.clickAddOwnerBtn();
//        newOwnerPage.fillOwner(owner);
//        ownersPage = newOwnerPage.clickAddOwnerButton();
//        assertEquals(newOwnerPage.errorOneLetterinName(), "First name must be at least 2 characters long");
//    }
//
//    @Story("Create Owner")
//    @Severity(SeverityLevel.MINOR)
//    @TmsLink("1116")
//    @Test(description="Add new owner with one letter in last name ")
//    public void addNewOwnerWithOneLetterInLastNameTest() {
//
//        ownersPage.openPage();
//        owner.setFirstName("Bob");
//        owner.setLastName("W");
//        owner.setAddress("street");
//        owner.setCity("Rivia");
//        owner.setTelephone("1818184284");
//        newOwnerPage = ownersPage.clickAddOwnerBtn();
//        newOwnerPage.fillOwner(owner);
//        ownersPage = newOwnerPage.clickAddOwnerButton();
//        assertEquals(newOwnerPage.errorOneLetterinName(), "Last name must be at least 2 characters long");
//    }
//
//    @Story("Create Owner")
//    @Severity(SeverityLevel.MINOR)
//    @TmsLink("1113")
//    @Test(description="Add new owner with  letter in phone ")
//    public void addNewOwnerWithDigitsInPhoneTest() {
//
//        ownersPage.openPage();
//        owner.setFirstName("Bob");
//        owner.setLastName("Web");
//        owner.setAddress("street");
//        owner.setCity("Rivia");
//        owner.setTelephone("fhfhfhfh");
//        newOwnerPage = ownersPage.clickAddOwnerBtn();
//        newOwnerPage.fillOwner(owner);
//        ownersPage = newOwnerPage.clickAddOwnerButton();
//        assertEquals(newOwnerPage.errorLetterInPhone(), "Phone number only accept digits");
//    }
//
//    @Story("Create Owner")
//    @Severity(SeverityLevel.MINOR)
//    @TmsLink("1115")
//    @Test(description="Add new owner with  empty first name ")
//    public void addNewOwnerWithEmptyInNameTest() {
//
//        ownersPage.openPage();
//        owner.setFirstName("B");
//        owner.setLastName("Witcher");
//        owner.setAddress("street");
//        owner.setCity("Rivia");
//        owner.setTelephone("1818184284");
//        newOwnerPage = ownersPage.clickAddOwnerBtn();
//        newOwnerPage.fillOwner(owner);
//        clearField(newOwnerPage.firstNameField);
//        ownersPage = newOwnerPage.clickAddOwnerButton();
//        assertEquals(newOwnerPage.errorEmptyFild(), "First name is required");
//
//
//    }
//
//    @Story("Create Owner")
//    @Severity(SeverityLevel.MINOR)
//    @TmsLink("1113")
//    @Test(description="Add new owner with  empty last name ")
//    public void addNewOwnerWithEmptyInLastNameTest() {
//
//        ownersPage.openPage();
//        owner.setFirstName("Bob");
//        owner.setLastName("W");
//        owner.setAddress("street");
//        owner.setCity("Rivia");
//        owner.setTelephone("1818184284");
//        newOwnerPage = ownersPage.clickAddOwnerBtn();
//        newOwnerPage.fillOwner(owner);
//        clearField(newOwnerPage.lastNameField);
//        ownersPage = newOwnerPage.clickAddOwnerButton();
//        assertEquals(newOwnerPage.errorEmptyFild(), "Last name is required");
//
//
//    }
//
//    @Story("Create Owner")
//    @Severity(SeverityLevel.MINOR)
//    @TmsLink("1114")
//    @Test(description="Add new owner with  empty address ")
//    public void addNewOwnerWithEmptyAddressTest() {
//
//        ownersPage.openPage();
//        owner.setFirstName("Bob");
//        owner.setLastName("Wow");
//        owner.setAddress("s");
//        owner.setCity("Rivia");
//        owner.setTelephone("1818184284");
//        newOwnerPage = ownersPage.clickAddOwnerBtn();
//        newOwnerPage.fillOwner(owner);
//        clearField(newOwnerPage.addressField);
//        ownersPage = newOwnerPage.clickAddOwnerButton();
//        assertEquals(newOwnerPage.errorEmptyFild(), "Address is required");
//
//
//    }
//
//    @Story("Create Owner")
//    @Severity(SeverityLevel.MINOR)
//    @TmsLink("1113")
//    @Test(description="Add new owner with  empty city ")
//    public void addNewOwnerWithEmptyCityTest() {
//
//        ownersPage.openPage();
//        owner.setFirstName("Bob");
//        owner.setLastName("Wow");
//        owner.setAddress("Gagarina");
//        owner.setCity("R");
//        owner.setTelephone("1818184284");
//        newOwnerPage = ownersPage.clickAddOwnerBtn();
//        newOwnerPage.fillOwner(owner);
//        clearField(newOwnerPage.cityField);
//        ownersPage = newOwnerPage.clickAddOwnerButton();
//        assertEquals(newOwnerPage.errorEmptyFild(), "City is required");
//
//
//    }
//
//    @Story("Create Owner")
//    @Severity(SeverityLevel.MINOR)
//    @TmsLink("1113")
//    @Test(description="Add new owner with  empty phone ")
//    public void addNewOwnerWithEmptyPhoneTest() {
//
//        ownersPage.openPage();
//        owner.setFirstName("Bob");
//        owner.setLastName("Wow");
//        owner.setAddress("Gagarina");
//        owner.setCity("Rome");
//        owner.setTelephone("1");
//        newOwnerPage = ownersPage.clickAddOwnerBtn();
//        newOwnerPage.fillOwner(owner);
//        clearField(newOwnerPage.telephoneField);
//        ownersPage = newOwnerPage.clickAddOwnerButton();
//        assertEquals(newOwnerPage.errorEmptyFild(), "Phone number is required");
//
//
//    }
}