package com.automation.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class SimpleUITest {
    private WebDriver driver;
    private String baseUrl = "https://selenium.dev/";
    private String projectUrl = "https://selenium.dev/projects/";
    private String documentationUrl = "https://selenium.dev/documentation/en/";
    private String supportUrl = "https://selenium.dev/support/";
    private String blogUrl = "https://selenium.dev/blog/";


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

    @Test(priority = 1)
    public void openSeleniumMainURLTest() {
        driver.get(baseUrl);
        assertURL(baseUrl);


    }

    @Test(priority = 2)
    public void seleniumMainURLPageTitleTest() {
        driver.get(baseUrl);
        String pagetitle = "SeleniumHQ Browser Automation";
        assertPageTitle(pagetitle);

    }

    @Test(priority = 3)
    public void seleniumProjectURLTest() {
        driver.get(projectUrl);
        assertURL(projectUrl);

    }

    @Test(priority = 4)
    public void seleniumProjectPageTitleTest() {
        String pagetitle = "Selenium Projects";
        driver.get(projectUrl);
        assertPageTitle(pagetitle);

    }

    @Test(priority = 5)
    public void seleniumDocumentationURLTest() {
        driver.get(documentationUrl);
        assertURL(documentationUrl);

    }
    @Test(priority = 6)
    public void seleniumDocumentationPageTitleTest() {
        String pagetitle = "The Selenium Browser Automation Project :: Documentation for Selenium";
        driver.get(documentationUrl);
        assertPageTitle(pagetitle);

    }
    @Test(priority = 7)
    public void seleniumSupportURLTest() {
        driver.get(supportUrl);
        assertURL(supportUrl);

    }
    @Test(priority = 8)
    public void seleniumSupportPageTitleTest() {
        String pagetitle = "Selenium Support";
        driver.get(supportUrl);
        assertPageTitle(pagetitle);

    }

    @Test(priority = 9)
    public void seleniumBlogURLTest() {
        driver.get(blogUrl);
        assertURL(blogUrl);

    }

    @Test(priority = 10)
    public void seleniumBlogPageTitleTest() {
        String pagetitle = "Selenium Blog";
        driver.get(blogUrl);
        assertPageTitle(pagetitle);

    }
    @Test(priority = 11)
    public void seleniumAboutURLTest() {
        driver.get(baseUrl);
       // driver.findElement(By.xpath("//*[@id="navbar"]/div[1]/span"));
        driver.get(blogUrl);
        assertURL(blogUrl);

    }

    @Test(priority = 12)
    public void seleniumAboutPageTitleTest() {
        String pagetitle = "Selenium Blog";
        driver.get(blogUrl);
        assertPageTitle(pagetitle);

    }
    private void assertPageTitle(String pageTitle) {
        String currentTitle = driver.getTitle();
        assertEquals(currentTitle, pageTitle);
    }

    private void assertURL(String baseUrl) {
        String currentURL = driver.getCurrentUrl();
        assertEquals(currentURL, baseUrl);
    }
}
