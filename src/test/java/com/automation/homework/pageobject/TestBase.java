package com.automation.homework.pageobject;

import com.automation.homework.pageobject.owners.OwnersPage;
import com.automation.homework.pageobject.specialities.NewSpecialtiesPage;
import com.automation.homework.pageobject.specialities.SpecialtiesObject;
import com.automation.homework.pageobject.specialities.SpecialtiesPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    private static final String BASE_URL = "http://139.59.149.247:8000/petclinic";

    public WebDriver driver;



    @BeforeClass
    public void setUpDriver()
    {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    protected OwnersPage goToOwnersPage() {
        goToUrl(BASE_URL + "/owners", "Owners");
        return new OwnersPage(driver);
    }

    protected void goToVetsPage() {
        goToUrl(BASE_URL + "/vets","Veterinarians");
    }

    protected void goToPetTypesPage() {
        goToUrl(BASE_URL + "/pettypes",  "Pet Types");
    }

    protected void goToSpecialtiesPage() {
        goToUrl(BASE_URL + "/specialties",  "Specialties");
    }

    protected WebDriverWait waitFor() {
        return new WebDriverWait(driver, 4);
    }

    protected void goToUrl(String url, String title) {
        driver.get(url);
        waitFor().withMessage(title+ " page is not open!")
                .until(ExpectedConditions.textToBe(By.xpath("//h2"), title));
    }

    public WebElement getLastItem(String id ,String name) {
        WebElement lastItem = driver.findElement(By.xpath("//*[@id='"+id+"']/tbody/tr[last()]//*[@name='"+name+"']"));
        return lastItem;
    }
}

