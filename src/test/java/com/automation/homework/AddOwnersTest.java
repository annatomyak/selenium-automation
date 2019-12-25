package com.automation.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class AddOwnersTest {
    private WebDriver driver;
    @BeforeClass
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void addOwnerPositiveTest(){
        goToOwnerPage();
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
        goToOwnerPage();
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
        goToOwnerPage();
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
        goToOwnerPage();
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
        goToOwnerPage();
        enterFirstName("");
        enterLastName("");
        enterAddress("");
        enterCity("");
        enterPhone("");
        clickAddOwner();
        assertEquals(assertOwnerInfoInTable(""),"");



    }


    public void goToOwnerPage(){
        driver.get("http://139.59.149.247:8000");
        WebElement ownerMenuItem=driver.findElement(By.xpath("//a[@class='dropdown-toggle'][text()='Owners']"));
        ownerMenuItem.click();
        WebElement addOwners= driver.findElement(By.xpath( "/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[2]/a/span[2]"));
        addOwners.click();
       ;
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
       // WebElement ownerTable=driver.findElement(By.xpath("//*[@class='table-responsive']"));
       String res="";

        try {
            WebElement expectedOwnerInfo=driver.findElement(By.xpath("//a[text()='"+info+"']"));
            res=expectedOwnerInfo.getText();
        } catch (NoSuchElementException ex) {
        }

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
