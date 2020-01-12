package com.automation.homework.pageobject.specialities;

import com.automation.homework.pageobject.BasePage;
import org.openqa.selenium.WebDriver;

public class SpecialtiesObject extends BasePage {

    public SpecialtiesObject(WebDriver driver) {
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
