package com.automation.homework.pageobject.pets;

import com.automation.homework.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static org.testng.Assert.assertTrue;

public class NewPetTypesPage extends BasePage {

    public NewPetTypesPage(WebDriver driver) {
        super(driver);

    }

    public void fillPetTypes(PetTypesObject petTypesObject) {
        setPetTypes(petTypesObject.getName());
    }

    public void setPetTypes(String petTypes) {
        WebElement petTypefield = driver.findElement(By.xpath("//*[@id='name']"));
        petTypefield.clear();
        petTypefield.sendKeys(petTypes);
    }

    public NewPetTypesPage clickSavePetTypesBtn() {
        WebElement saveButton = driver.findElement(By.xpath("//*[text()='Save']"));
        saveButton.click();
        waitFor().until(ExpectedConditions.invisibilityOf(saveButton));
        boolean isStaneless = waitFor().until(ExpectedConditions.stalenessOf(saveButton));
        assertTrue(isStaneless, "Dont save item");
        return new NewPetTypesPage(driver);
    }

    public NewPetTypesPage clickSavePetTypes() {
        WebElement saveButton = driver.findElement(By.xpath("//*[text()='Save']"));
        saveButton.click();
        return new NewPetTypesPage(driver);
    }

    public NewPetTypesPage clickAddPetTypesButton() {
        WebElement addPetTypesBtn = driver.findElement(By.xpath("//*[text()=' Add ']"));
        addPetTypesBtn.click();
        return new NewPetTypesPage(driver);
    }
}
