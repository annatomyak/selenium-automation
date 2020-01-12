package com.automation.homework.pageobject.vets;
import com.automation.homework.pageobject.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import com.automation.homework.pageobject.owners.Owner;
import com.automation.homework.pageobject.owners.OwnersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewVeterinarians extends BasePage {
    private By firstNameField = By.id("firstName");
    private By lastNameField =By.id("lastName");
    private By AddVetButton =By.xpath("//*[text()='Save Vet']");


    public NewVeterinarians(WebDriver driver) {
        super(driver);
    }

    public void fillVet(VeterinarianObject veterinarianObject) {
        setFirstName(veterinarianObject.getFirstName());
        setLastName(veterinarianObject.getLastName());
        setType(veterinarianObject.getType());

    }

    public void setFirstName(String firstName) {
        WebElement firstNameInput = driver.findElement(firstNameField);
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        WebElement lastNameFieldInput = driver.findElement(lastNameField);
        lastNameFieldInput.clear();
        lastNameFieldInput.sendKeys(lastName);
    }

    public void setType(String select) {
        new Select(driver.findElement(By.id("specialties"))).selectByVisibleText(select);
    }


    public NewVeterinarians clickAddVetButton() {
        WebElement addVetBtn = driver.findElement(AddVetButton);
        addVetBtn.click();
        return new NewVeterinarians(driver);
    }
    public void clearFirstName() {
        WebElement firstNameInput = driver.findElement(firstNameField);
        firstNameInput.sendKeys(Keys.BACK_SPACE);
    }
    public void clearLastName() {
        WebElement lastNameFieldInput = driver.findElement(lastNameField);
        lastNameFieldInput.sendKeys(Keys.BACK_SPACE);
    }

}
