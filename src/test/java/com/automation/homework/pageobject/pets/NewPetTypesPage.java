package com.automation.homework.pageobject.pets;
import com.automation.homework.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static org.testng.Assert.assertTrue;

public class NewPetTypesPage extends BasePage {
    private By petField = By.xpath("//*[@id='name']");
    private By saveBtn = By.xpath("//*[text()='Save']");
    private By addBtn = By.xpath("//*[text()=' Add ']");


    public NewPetTypesPage(WebDriver driver) {
        super(driver);

    }

    public void fillPetTypes(PetTypesObject petTypesObject) {
        setPetTypes(petTypesObject.getName());
    }

    public void setPetTypes(String petTypes) {
        WebElement petTypefield = driver.findElement(petField);
        petTypefield.clear();
        petTypefield.sendKeys(petTypes);
    }

    public NewPetTypesPage clickSavePetTypesBtn() {
        WebElement saveButton = driver.findElement(saveBtn);
        saveButton.click();
        waitFor().until(ExpectedConditions.invisibilityOf(saveButton));
        boolean isStaneless = waitFor().until(ExpectedConditions.stalenessOf(saveButton));
        assertTrue(isStaneless, "Dont save item");
        return new NewPetTypesPage(driver);
    }

    public NewPetTypesPage clickSavePetTypes() {
        WebElement saveButton = driver.findElement(saveBtn);
        saveButton.click();
        return new NewPetTypesPage(driver);
    }

    public NewPetTypesPage clickAddPetTypesButton() {
        WebElement addPetTypesBtn = driver.findElement(addBtn);
        addPetTypesBtn.click();
        return new NewPetTypesPage(driver);
    }
}
