package com.automation.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Project {
    WebDriver driver;
    private String baseUrl = "https://selenium.dev/";
    @BeforeClass
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void projectTest(){
        driver.get(baseUrl);
       WebElement projectLink= driver.findElement(By.cssSelector("#navbar a[href='/projects']"));
        projectLink.click();
        String projectTitle=driver.getTitle();
        assertEquals(projectTitle,"Selenium Projects");

        WebElement projectDesc = driver.findElement(By.cssSelector(".body-large"));
        String projectDescText=projectDesc.getText();
        assertEquals(projectDescText,"Selenium has many projects that combine to form a versatile testing system.");
       List<WebElement>seleniumProject= driver.findElements(By.cssSelector(".product-container"));
        assertEquals(seleniumProject.size(),3);
        String webdriverTitle="Selenium WebDriver";


        List<String>titleList=new ArrayList<>();
        for (WebElement product : seleniumProject) {
      WebElement productTitle= product.findElement(By.tagName("h2"));


        }
    }

}