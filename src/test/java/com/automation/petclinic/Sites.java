package com.automation.petclinic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Sites {
    private WebDriver driver;
    @BeforeClass
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void domTest(){
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
        getInfo("Adipisci5");
    }
    public String getInfo(String text){
        return driver.findElement(By.xpath("//tr/td[text()='"+text+"']/following-sibling::td")).getText();
    }
}
