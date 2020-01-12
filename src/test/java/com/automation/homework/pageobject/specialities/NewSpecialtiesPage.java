package com.automation.homework.pageobject.specialities;

import com.automation.homework.pageobject.owners.OwnersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class NewSpecialtiesPage {
    private WebDriver driver;

    public NewSpecialtiesPage(WebDriver driver) {
        this.driver = driver;
    }
    public void fillSpecialties(SpecialtiesObject specialtiesObject){
        setSpecialties(specialtiesObject.getName());
    }

    public void setSpecialties(String specialties){
        WebElement fieldSpecialties=driver.findElement(By.xpath("//*[@id='name']"));
        fieldSpecialties.clear();
        fieldSpecialties.sendKeys(specialties);
    }
    public NewSpecialtiesPage clickSaveSpecialityBtn() {
        WebElement saveButton=driver.findElement(By.xpath("//*[@id='specialty']/div[2]/div/button"));
        saveButton.click();
        WebDriverWait wait =new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.invisibilityOf(saveButton));
        boolean isStaneless= wait.until(ExpectedConditions.stalenessOf(saveButton));
        assertTrue(isStaneless,"bjbju");
        return new NewSpecialtiesPage(driver);
    }
    public NewSpecialtiesPage clickSaveSpeciality() {
        WebElement saveButton=driver.findElement(By.xpath("//*[@id='specialty']/div[2]/div/button"));
        saveButton.click();
        return new NewSpecialtiesPage(driver);
    }


    public SpecialtiesPage clickAddSpecialityButton() {
        WebElement addSpecialityBtn = driver.findElement(By.xpath("//*[text()=' Add ']"));
        addSpecialityBtn.click();
        return new SpecialtiesPage(driver);
    }

}
