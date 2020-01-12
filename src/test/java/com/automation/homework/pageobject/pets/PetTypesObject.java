package com.automation.homework.pageobject.pets;

import com.automation.homework.pageobject.BasePage;
import org.openqa.selenium.WebDriver;

public class PetTypesObject extends BasePage {

    public PetTypesObject(WebDriver driver) {
        super(driver);
    }

    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SpecialtiesObject{" +
                "name='" + name + '\'' +
                '}';
    }
}
