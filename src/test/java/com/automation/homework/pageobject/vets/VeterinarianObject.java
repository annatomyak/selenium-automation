package com.automation.homework.pageobject.vets;

import com.automation.homework.pageobject.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class VeterinarianObject extends BasePage {
    private String firstName;
    private String lastName;
    private String type;

    public VeterinarianObject(WebDriver driver) {
        super(driver);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "VeterinarianObject{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VeterinarianObject)) return false;
        VeterinarianObject that = (VeterinarianObject) o;
        return Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getType(), that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getType());
    }
}
