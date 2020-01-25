package com.automation.homework.pageobject.specialities;
import com.automation.homework.pageobject.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertTrue;

public class NewSpecialtiesPage extends BasePage {

    private By fieldSpec = By.xpath("//*[@id='name']");
    private By saveBtn = By.xpath("//*[@id='specialty']/div[2]/div/button");
    private By addBtn = By.xpath("//*[@id='specialty']/div[2]/div/button");

    public NewSpecialtiesPage(WebDriver driver) {
        super(driver);

    }
    @Step
    public void fillSpecialties(SpecialtiesObject specialtiesObject){
        setSpecialties(specialtiesObject.getName());
    }
    @Step
    public void setSpecialties(String specialties){
        WebElement fieldSpecialties=driver.findElement(fieldSpec);
        fieldSpecialties.clear();
        fieldSpecialties.sendKeys(specialties);
    }
    @Step
    public NewSpecialtiesPage clickSaveSpecialityBtn() {
        WebElement saveButton=driver.findElement(saveBtn);
        saveButton.click();
        waitFor().until(ExpectedConditions.invisibilityOf(saveButton));
        boolean isStaneless= waitFor().until(ExpectedConditions.stalenessOf(saveButton));
        assertTrue(isStaneless,"Dont Save");
        return new NewSpecialtiesPage(driver);
    }
    @Step
    public NewSpecialtiesPage clickSaveSpeciality() {
        WebElement saveButton=driver.findElement(saveBtn);
        saveButton.click();
        return new NewSpecialtiesPage(driver);
    }

    @Step
    public SpecialtiesPage clickAddSpecialityButton() {
        WebElement addSpecialityBtn = driver.findElement(addBtn);
        addSpecialityBtn.click();
        return new SpecialtiesPage(driver);
    }

}
