package com.automation.homework.pageobject.owners;
import com.automation.homework.pageobject.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class NewOwnerPage extends BasePage {

    public By firstNameField = By.id("firstName");
    public By lastNameField =By.id("lastName");
    public By addressField =By.id("address");
    public By cityField = By.id("city");
    public By telephoneField = By.id("telephone");

    public NewOwnerPage(WebDriver driver) {
        super(driver);
    }
    @Step
    public void fillOwner(Owner owner) {
        setFirstName(owner.getFirstName());
        setLastName(owner.getLastName());
        setAddress(owner.getAddress());
        setCity(owner.getCity());
        setTelephone(owner.getTelephone());
    }
    @Step
    public void setFirstName(String firstName) {
        WebElement firstNameInput = driver.findElement(firstNameField);
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    @Step
    public void setLastName(String lastName) {
        WebElement lastNameFieldInput = driver.findElement(lastNameField);
        lastNameFieldInput.clear();
        lastNameFieldInput.sendKeys(lastName);
    }
    @Step
    public void setAddress(String address) {
        WebElement addressFieldInput = driver.findElement(addressField);
        addressFieldInput.clear();
        addressFieldInput.sendKeys(address);
    }
    @Step
    public void setCity(String city) {
        WebElement cityFieldInput = driver.findElement(cityField);
        cityFieldInput.clear();
        cityFieldInput.sendKeys(city);
    }
    @Step
    public void setTelephone(String telephone) {
        WebElement telephoneFieldInput = driver.findElement(telephoneField);
        telephoneFieldInput.clear();
        telephoneFieldInput.sendKeys(telephone);
    }
    @Step
    public OwnersPage clickAddOwnerButton() {
        WebElement addOwnerBtn = driver.findElement(By.xpath("//*[text()='Add Owner']"));
        addOwnerBtn.click();
        return new OwnersPage(driver);
    }

}


