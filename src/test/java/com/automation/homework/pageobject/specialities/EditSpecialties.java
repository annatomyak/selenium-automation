package com.automation.homework.pageobject.specialities;

import com.automation.homework.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class EditSpecialties extends BasePage {


    public EditSpecialties(WebDriver driver) {
        super(driver);

    }
    public void setSpecialties(String specialties){
        WebElement fieldSpecialties=driver.findElement(By.xpath("//*[@id='name']"));
        fieldSpecialties.clear();
        fieldSpecialties.sendKeys(specialties);
    }
    public EditSpecialties clickUpdate() {
        WebElement clickUpdatebutton=driver.findElement(By.xpath("//*[text()='Update']"));
        clickUpdatebutton.click();
        return new EditSpecialties(driver);
    }
    public EditSpecialties deleteSpecialties() {
        WebElement clickDeleteButton=driver.findElement(By.xpath("//*[@id='specialties']/tbody/tr[last()]/td[2]/button[2]"));
        clickDeleteButton.click();
        waitFor().until(ExpectedConditions.invisibilityOf(clickDeleteButton));
        boolean isStaneless= waitFor().until(ExpectedConditions.stalenessOf(clickDeleteButton));
        assertTrue(isStaneless,"Dont delete element!");
        return new EditSpecialties(driver);
    }
    public List<WebElement> getListElements(String id) {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='" + id + "']//tbody/tr"));
        return elements;
    }


}
