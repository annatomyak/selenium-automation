package com.automation.homework.pageobject.pets;
import com.automation.homework.pageobject.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class PetTypesPage extends BasePage {
    public PetTypesPage(WebDriver driver) {
        super(driver);

    }
    @Step
    public PetTypesPage openPage() {
        goToUrl("/pettypes", "Pet Types");
        return this;
    }

    @Step
    public PetTypesPage editPetTypes() {

        WebElement lastEditButton=driver.findElement(By.xpath("//*[@id='pettypes']/tbody/tr[last()]/td[2]/button[1]"));
        lastEditButton.click();
        waitFor().until(ExpectedConditions.invisibilityOf(lastEditButton));
        boolean isStaneless= waitFor().until(ExpectedConditions.stalenessOf(lastEditButton));
        assertTrue(isStaneless,"Dont save");
        return new PetTypesPage(driver) ;
    }
    @Step
    public PetTypesPage clickUpdate() {
        WebElement clickUpdatebutton=driver.findElement(By.xpath("//*[text()='Update']"));
        clickUpdatebutton.click();
        return new PetTypesPage(driver);
    }
    @Step
    public PetTypesPage deletePetTypes() {
        WebElement clickDeleteButton=driver.findElement(By.xpath("//*[@id='pettypes']/tbody/tr[last()]/td[2]/button[2]"));
        clickDeleteButton.click();
        waitFor().until(ExpectedConditions.invisibilityOf(clickDeleteButton));
        boolean isStaneless= waitFor().until(ExpectedConditions.stalenessOf(clickDeleteButton));
        assertTrue(isStaneless,"Dont delete element!");

        return new PetTypesPage(driver);
    }
    @Step
    public List<WebElement> getListElements(String id) {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='" + id + "']//tbody/tr"));
        return elements;
    }
}
