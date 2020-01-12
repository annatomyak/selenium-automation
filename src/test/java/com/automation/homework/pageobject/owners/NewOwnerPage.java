package com.automation.homework.pageobject.owners;

import com.automation.homework.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class NewOwnerPage extends BasePage {

    private By firstNameField = By.id("firstName");
    private By lastNameField =By.id("lastName");
    private By addressField =By.id("address");
    private By cityField = By.id("city");
    private By telephoneField = By.id("telephone");

    public NewOwnerPage(WebDriver driver) {
        super(driver);
    }

    public void fillOwner(Owner owner) {
        setFirstName(owner.getFirstName());
        setLastName(owner.getLastName());
        setAddress(owner.getAddress());
        setCity(owner.getCity());
        setTelephone(owner.getTelephone());
    }

    public void setFirstName(String firstName) {
        WebElement firstNameInput = driver.findElement(firstNameField);
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }
    public void clearFirstName() {
        WebElement firstNameInput = driver.findElement(firstNameField);
        firstNameInput.sendKeys(Keys.BACK_SPACE);
    }
    public void clearLastName() {
        WebElement lastNameFieldInput = driver.findElement(lastNameField);
        lastNameFieldInput.sendKeys(Keys.BACK_SPACE);
    }
    public void clearAdress() {
        WebElement addressFieldInput = driver.findElement(addressField);
        addressFieldInput.sendKeys(Keys.BACK_SPACE);
    }
    public void clearCity() {
        WebElement cityFieldInput = driver.findElement(cityField);
        cityFieldInput.sendKeys(Keys.BACK_SPACE);
    }
    public void clearPhone() {
        WebElement telephoneFieldInput = driver.findElement(telephoneField);
        telephoneFieldInput.sendKeys(Keys.BACK_SPACE);
    }

    public void setLastName(String lastName) {
        WebElement lastNameFieldInput = driver.findElement(lastNameField);
        lastNameFieldInput.clear();
        lastNameFieldInput.sendKeys(lastName);
    }

    public void setAddress(String address) {
        WebElement addressFieldInput = driver.findElement(addressField);
        addressFieldInput.clear();
        addressFieldInput.sendKeys(address);
    }

    public void setCity(String city) {
        WebElement cityFieldInput = driver.findElement(cityField);
        cityFieldInput.clear();
        cityFieldInput.sendKeys(city);
    }

    public void setTelephone(String telephone) {
        WebElement telephoneFieldInput = driver.findElement(telephoneField);
        telephoneFieldInput.clear();
        telephoneFieldInput.sendKeys(telephone);
    }

    public OwnersPage clickAddOwnerButton() {
        WebElement addOwnerBtn = driver.findElement(By.xpath("//*[text()='Add Owner']"));
        addOwnerBtn.click();
        return new OwnersPage(driver);
    }

}


