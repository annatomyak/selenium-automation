package com.automation.homework.pageobject.specialities;
import com.automation.homework.pageobject.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;

import static org.testng.Assert.assertTrue;

public class EditSpecialties extends BasePage {
    private By updateBtn = By.xpath("//*[text()='Update']");
    private By deleteLastItemBtn = By.xpath("//*[@id='specialties']/tbody/tr[last()]/td[2]/button[2]");

    public EditSpecialties(WebDriver driver) {
        super(driver);

    }
    @Step
    public EditSpecialties clickUpdate() {
        WebElement clickUpdatebutton=driver.findElement(updateBtn);
        clickUpdatebutton.click();
        return new EditSpecialties(driver);
    }
    @Step
    public EditSpecialties deleteSpecialties() {
        WebElement clickDeleteButton=driver.findElement(deleteLastItemBtn);
        clickDeleteButton.click();
        waitFor().until(ExpectedConditions.invisibilityOf(clickDeleteButton));
        boolean isStaneless= waitFor().until(ExpectedConditions.stalenessOf(clickDeleteButton));
        assertTrue(isStaneless,"Dont delete element!");
        return new EditSpecialties(driver);
    }
    @Step
    public List<WebElement> getListElements(String id) {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='" + id + "']//tbody/tr"));
        return elements;
    }


}
