package com.automation.homework.pageobject.tests;
import com.automation.homework.pageobject.TestBase;
import com.automation.homework.pageobject.owners.NewOwnerPage;
import com.automation.homework.pageobject.owners.Owner;
import com.automation.homework.pageobject.owners.OwnersPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;


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

    @Test
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

    @Test
    public void addNewOwnerWithOneLetterInNameTest() {

        ownersPage.openPage();
        owner.setFirstName("B");
        owner.setLastName("Witcher");
        owner.setAddress("street");
        owner.setCity("Rivia");
        owner.setTelephone("1818184284");
        newOwnerPage = ownersPage.clickAddOwnerBtn();
        newOwnerPage.fillOwner(owner);
        ownersPage = newOwnerPage.clickAddOwnerButton();
        assertEquals(newOwnerPage.errorOneLetterinName(), "First name must be at least 2 characters long");
    }

    @Test
    public void addNewOwnerWithOneLetterInLastNameTest() {

        ownersPage.openPage();
        owner.setFirstName("Bob");
        owner.setLastName("W");
        owner.setAddress("street");
        owner.setCity("Rivia");
        owner.setTelephone("1818184284");
        newOwnerPage = ownersPage.clickAddOwnerBtn();
        newOwnerPage.fillOwner(owner);
        newOwnerPage.clearFirstName();
        ownersPage = newOwnerPage.clickAddOwnerButton();
        assertEquals(newOwnerPage.errorOneLetterinName(), "Last name must be at least 2 characters long");
    }

    @Test
    public void addNewOwnerWithDigitsInPhoneTest() {

        ownersPage.openPage();
        owner.setFirstName("Bob");
        owner.setLastName("Web");
        owner.setAddress("street");
        owner.setCity("Rivia");
        owner.setTelephone("fhfhfhfh");
        newOwnerPage = ownersPage.clickAddOwnerBtn();
        newOwnerPage.fillOwner(owner);
        ownersPage = newOwnerPage.clickAddOwnerButton();
        assertEquals(newOwnerPage.errorLetterInPhone(), "Phone number only accept digits");
    }

    @Test
    public void addNewOwnerWithEmptyInNameTest() {

        ownersPage.openPage();
        owner.setFirstName("B");
        owner.setLastName("Witcher");
        owner.setAddress("street");
        owner.setCity("Rivia");
        owner.setTelephone("1818184284");
        newOwnerPage = ownersPage.clickAddOwnerBtn();
        newOwnerPage.fillOwner(owner);
        newOwnerPage.clearFirstName();
        ownersPage = newOwnerPage.clickAddOwnerButton();
        assertEquals(newOwnerPage.errorEmptyFild(), "First name is required");


    }

    @Test
    public void addNewOwnerWithEmptyInLastNameTest() {

        ownersPage.openPage();
        owner.setFirstName("Bob");
        owner.setLastName("W");
        owner.setAddress("street");
        owner.setCity("Rivia");
        owner.setTelephone("1818184284");
        newOwnerPage = ownersPage.clickAddOwnerBtn();
        newOwnerPage.fillOwner(owner);
        newOwnerPage.clearLastName();
        ownersPage = newOwnerPage.clickAddOwnerButton();
        assertEquals(newOwnerPage.errorEmptyFild(), "Last name is required");


    }

    @Test
    public void addNewOwnerWithEmptyAddressTest() {

        ownersPage.openPage();
        owner.setFirstName("Bob");
        owner.setLastName("Wow");
        owner.setAddress("s");
        owner.setCity("Rivia");
        owner.setTelephone("1818184284");
        newOwnerPage = ownersPage.clickAddOwnerBtn();
        newOwnerPage.fillOwner(owner);
        newOwnerPage.clearAdress();
        ownersPage = newOwnerPage.clickAddOwnerButton();
        assertEquals(newOwnerPage.errorEmptyFild(), "Address is required");


    }

    @Test
    public void addNewOwnerWithEmptyCityTest() {

        ownersPage.openPage();
        owner.setFirstName("Bob");
        owner.setLastName("Wow");
        owner.setAddress("Gagarina");
        owner.setCity("R");
        owner.setTelephone("1818184284");
        newOwnerPage = ownersPage.clickAddOwnerBtn();
        newOwnerPage.fillOwner(owner);
        newOwnerPage.clearCity();
        ownersPage = newOwnerPage.clickAddOwnerButton();
        assertEquals(newOwnerPage.errorEmptyFild(), "City is required");


    }

    @Test
    public void addNewOwnerWithEmptyPhoneTest() {

        ownersPage.openPage();
        owner.setFirstName("Bob");
        owner.setLastName("Wow");
        owner.setAddress("Gagarina");
        owner.setCity("Rome");
        owner.setTelephone("1");
        newOwnerPage = ownersPage.clickAddOwnerBtn();
        newOwnerPage.fillOwner(owner);
        newOwnerPage.clearPhone();
        ownersPage = newOwnerPage.clickAddOwnerButton();
        assertEquals(newOwnerPage.errorEmptyFild(), "Phone number is required");


    }
}