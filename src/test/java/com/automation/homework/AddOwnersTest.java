package com.automation.homework;

import com.automation.homework.pageobject.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AddOwnersTest extends TestBase {



    @Test
    public void addOwnerPositiveTest(){
        goToOwnersPage();
        enterFirstName("Anna");
        enterLastName("Test");
        enterAddress("Gagarina street");
        enterCity("Dnipro");
        enterPhone("159746574524174");
        clickAddOwner();
        assertEquals(assertOwnerInfoInTable("Anna Test"),"Anna Test");
        assertEquals(assertOwnerInfoInTable("Gagarina street"),"Gagarina street");
        assertEquals(assertOwnerInfoInTable("159746574524174"),"159746574524174");


    }
    @Test
    public void addOwnerTestWithOneLetterInFirstName(){
        goToOwnersPage();
        enterFirstName("A");
        enterLastName("Test");
        enterAddress("Gagarina street");
        enterCity("Dnipro");
        enterPhone("159746574524174");
        clickAddOwner();
        assertEquals(errorOneLetterinName(),"First name must be at least 2 characters long");

    }
    @Test
    public void addOwnerTestWithOneLetterInSecondName(){
        goToOwnersPage();
        enterFirstName("Anna");
        enterLastName("T");
        enterAddress("Gagarina street");
        enterCity("Dnipro");
        enterPhone("159746574524174");
        clickAddOwner();
        assertEquals(errorOneLetterinName(),"Last name must be at least 2 characters long");

    }
    @Test
    public void addOwnerTestWithLetterInPhone(){
        goToOwnersPage();
        enterFirstName("Anna");
        enterLastName("Test");
        enterAddress("Gagarina street");
        enterCity("Dnipro");
        enterPhone("btgbtr");
        clickAddOwner();
        assertEquals(errorLetterInPhone(),"Phone number only accept digits");

    }
    @Test
    public void addOwnerTestWithEmptyField(){
        goToOwnersPage();
        enterFirstName("");
        enterLastName("");
        enterAddress("");
        enterCity("");
        enterPhone("");
        clickAddOwner();
        assertEquals(assertOwnerInfoInTable(""),"");



    }


    public void clickAddOwner(){
        WebElement ownerAddButton=driver.findElement(By.xpath("//button[@class='btn btn-default'][text()='Add Owner']"));
        ownerAddButton.click();
    }

    public void enterFirstName(String firstName){
        WebElement firstNameField=driver.findElement(By.xpath("//*[@id='firstName']"));
        firstNameField.clear();
        firstNameField.sendKeys(firstName);


    }
    public void enterLastName(String lastName){
        WebElement lastNameField=driver.findElement(By.xpath("//*[@id='lastName']"));
        lastNameField.clear();
        lastNameField.sendKeys(lastName);

    }
    public void enterAddress(String address){
        WebElement addressField=driver.findElement(By.xpath("//*[@id='address']"));
        addressField.clear();
        addressField.sendKeys(address);

    }
    public void enterCity(String city){
        WebElement cityField=driver.findElement(By.xpath("//*[@id='city']"));
        cityField.clear();
        cityField.sendKeys(city);

    }
    public void enterPhone(String phone){
        WebElement phoneField=driver.findElement(By.xpath("//*[@id='telephone']"));
        phoneField.clear();
        phoneField.sendKeys(phone);

    }
    public String assertOwnerInfoInTable(String info ) {
       String res="";
       try {
            WebElement expectedOwnerInfo=driver.findElement(By.xpath("//a[text()='"+info+"']"));
            res=expectedOwnerInfo.getText();
        } catch (NoSuchElementException ex) { }

       return res;
    }
    public String errorOneLetterinName(){
        WebElement errorOneletterInFirstName=driver.findElement(By.xpath("//span[@class='help-block']"));
        String expectedErrorOneletterInFirstName=errorOneletterInFirstName.getText();
        return expectedErrorOneletterInFirstName;
    }
    public String errorLetterInPhone(){
        WebElement errorLetterInPhone=driver.findElement(By.xpath("//span[@class='help-block']"));
        String expectedErrorLetterInPhone=errorLetterInPhone.getText();
        return expectedErrorLetterInPhone;
    }

}
