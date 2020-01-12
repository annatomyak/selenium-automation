package com.automation.petclinic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Specialities {
    private WebDriver driver;
    @BeforeClass
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void  addSpecialistTest(){
        driver.get("http://139.59.149.247:8000/petclinic/specialties");
        WebElement addButton=driver.findElement(By.xpath("//*[text()=' Add ']"));
        addButton.click();
        WebElement nameField=driver.findElement(By.xpath("//*[@id='name']"));

        assertTrue(nameField.isDisplayed(),"Name is displayed");
        nameField.clear();
        nameField.sendKeys("test");
        WebElement saveButton=driver.findElement(By.xpath("//*[@id='specialty']/div[2]/div/button"));
        saveButton.click();
        WebDriverWait wait =new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.invisibilityOf(saveButton));
       boolean isStaneless= wait.until(ExpectedConditions.stalenessOf(saveButton));
        assertTrue(isStaneless,"bjbju");
//        addButton.click();
          assertFalse(nameField.isDisplayed());
    }
}
