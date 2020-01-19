package com.automation.homework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private static final String BASE_URL = "http://139.59.149.247:8000/petclinic";

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    protected WebDriverWait waitFor() {
        return new WebDriverWait(driver, 4);
    }

    protected void goToUrl(String url, String title) {
        driver.get(BASE_URL + url);
        waitFor().withMessage(title+ " page is not open!")
                .until(ExpectedConditions.textToBe(By.xpath("//h2"), title));
    }
    public String errorOneLetterinName(){
        WebElement errorOneletterInFirstName=driver.findElement(By.xpath("//span[@class='help-block']"));
        String expectedErrorOneletterInFirstName=errorOneletterInFirstName.getText();
        return expectedErrorOneletterInFirstName;
    }
    public String errorLetterInPhone(){
        WebElement errorLetterInPhone=driver.findElement(By.xpath("//span[@class='help-block']"));
        String expectedErrorLetterInPhone=errorLetterInPhone.getText();
        return expectedErrorLetterInPhone;
    }
    public String errorEmptyFild(){
        WebElement errorEmptyFirstNameField=driver.findElement(By.xpath("//span[@class='help-block']"));
        errorEmptyFirstNameField.click();
        String expectedErrorOneletterInFirstName=errorEmptyFirstNameField.getText();
        return expectedErrorOneletterInFirstName;
    }


}
