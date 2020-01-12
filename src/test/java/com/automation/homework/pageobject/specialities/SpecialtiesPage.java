package com.automation.homework.pageobject.specialities;
import com.automation.homework.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;

import static org.testng.Assert.assertTrue;


public class SpecialtiesPage extends BasePage {

    public SpecialtiesPage(WebDriver driver) {
        super(driver);

    }

    public SpecialtiesPage openPage() {
        goToUrl("/specialties", "Specialties");
        return this;
    }
    public SpecialtiesPage openHomePage() {
        goToUrl("/welcome", "Welcome");
        return this;
    }

    public SpecialtiesPage editSpecialties() {

        WebElement lastEditButton=driver.findElement(By.xpath("//*[@id='specialties']/tbody/tr[last()]/td[2]/button[1]"));
        lastEditButton.click();
        waitFor().until(ExpectedConditions.invisibilityOf(lastEditButton));
        boolean isStaneless= waitFor().until(ExpectedConditions.stalenessOf(lastEditButton));
        assertTrue(isStaneless,"bjbju");
        return new SpecialtiesPage(driver) ;
    }
    public List<WebElement> getListElements(String id) {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='" + id + "']//tbody/tr"));
        return elements;
    }

}