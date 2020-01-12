package com.automation.homework.pageobject.vets;

import com.automation.homework.pageobject.BasePage;
import com.automation.homework.pageobject.TestBase;
import com.automation.homework.pageobject.owners.NewOwnerPage;
import com.automation.homework.pageobject.owners.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class VeterinariansPage extends BasePage {
    public VeterinariansPage(WebDriver driver) {

        super(driver);
    }

    public VeterinariansPage openPage() {
        goToUrl("/vets", "Veterinarians");
        return this;
    }


    public List<VeterinarianObject> getVetsList() {
        List<VeterinarianObject> vets = new ArrayList<>();
        WebElement vetsTable = driver.findElement(By.xpath("//*[@class='table table-striped']"));

        List<WebElement> vetList = vetsTable.findElements(By.xpath(".//tbody/tr"));
        for (WebElement userRow : vetList) {
            vets.add(createVet(userRow));
        }

        return vets;
    }

    public VeterinariansPage clickAddVetBtn() {
        WebElement clickAddVet = driver.findElement(By.xpath("//*[text()='Add Vet']"));
        clickAddVet.click();
        return new VeterinariansPage(driver);
    }

    private VeterinarianObject createVet(WebElement userRow) {
        VeterinarianObject veterinarianObject = new VeterinarianObject(driver);
        String fullName = userRow.findElement(By.xpath("./td[1]")).getText();
        String[] fullNameArray = fullName.split(" ");
        if (fullNameArray.length > 1) {
            veterinarianObject.setFirstName(fullNameArray[0]);
            veterinarianObject.setLastName(fullNameArray[1]);
        } else {
            veterinarianObject.setFirstName(fullNameArray[0]);
        }
        String typeField = userRow.findElement(By.xpath("./td[2]")).getText();
        if (!typeField.isEmpty()) {
            veterinarianObject.setType(typeField);
        }

        return veterinarianObject;
    }
}
