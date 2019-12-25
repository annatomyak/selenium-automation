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

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class OwnerTest {
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
    public  void addOwners(){
        driver.get("http://139.59.149.247:8000");
        WebElement ownerMenuItem=driver.findElement(By.xpath("//a[@class='dropdown-toggle'][text()='Owners']"));
        ownerMenuItem.click();
        WebElement allOwners= driver.findElement(By.xpath("//a[@routerlink='/owners']"));
        allOwners.click();
        WebElement ownerTable=driver.findElement(By.xpath("//*[@class='table-responsive']"));
        assertTrue(ownerTable.isDisplayed());
        List<WebElement> ownerList=ownerTable.findElements(By.xpath(".//tbody/tr"));
        assertFalse(ownerList.isEmpty());
        WebElement userRow= ownerList.get(0);
        userRow.click();



        //System.out.println(owner);

    }
    public Owner createOwner (WebElement userRow){
    Owner owner=new Owner();
    owner.setName(userRow.findElement(By.xpath("./td/a")).getText());
    owner.setAddress(userRow.findElement(By.xpath("./td[2]")).getText());
    owner.setCity(userRow.findElement(By.xpath(".td[3]")).getText());
    owner.setPhone(userRow.findElement(By.xpath(".td[4]")).getText());
    owner.setPet(userRow.findElement(By.xpath(".td[5]")).getText());
    return owner;
}
//public String getInfo(){
//    //return driver.findElement()
//}
}
