package com.automation.homework.pageobject.vets;
import com.automation.homework.pageobject.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewVeterinarians extends BasePage {
    public By firstNameField = By.id("firstName");
    public By lastNameField =By.id("lastName");
    private By AddVetButton =By.xpath("//*[text()='Save Vet']");


    public NewVeterinarians(WebDriver driver) {
        super(driver);
    }
    @Step
    public void fillVet(VeterinarianObject veterinarianObject) {
        setFirstName(veterinarianObject.getFirstName());
        setLastName(veterinarianObject.getLastName());
        setType(veterinarianObject.getType());

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
    public void setType(String select) {
        new Select(driver.findElement(By.id("specialties"))).selectByVisibleText(select);
    }

    @Step
    public NewVeterinarians clickAddVetButton() {
        WebElement addVetBtn = driver.findElement(AddVetButton);
        addVetBtn.click();
        return new NewVeterinarians(driver);
    }

}
