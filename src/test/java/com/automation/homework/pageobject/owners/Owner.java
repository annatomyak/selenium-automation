package com.automation.homework.pageobject.owners;

import com.automation.homework.pageobject.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.Objects;


    public class Owner extends BasePage {

        private String firstName;
        private String lastName;
        private String address;
        private String city;
        private String telephone;
        private String pets;

        public Owner(WebDriver driver) {
            super(driver);
        }
        @Step
        public String getFirstName() {
            return firstName;
        }
        @Step
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        @Step
        public String getLastName() {
            return lastName;
        }
        @Step
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        @Step
        public String getAddress() {
            return address;
        }
        @Step
        public void setAddress(String address) {
            this.address = address;
        }
        @Step
        public String getCity() {
            return city;
        }
        @Step
        public void setCity(String city) {
            this.city = city;
        }
        @Step
        public String getTelephone() {
            return telephone;
        }
        @Step
        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }
        @Step
        public String getPets() {
            return pets;
        }
        @Step
        public void setPets(String pets) {
            this.pets = pets;
        }


        @Override
        public String toString() {
            return "Owner{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", address='" + address + '\'' +
                    ", city='" + city + '\'' +
                    ", telephone='" + telephone + '\'' +
                    ", pets='" + pets + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Owner)) return false;
            Owner owner = (Owner) o;
            return Objects.equals(getFirstName(), owner.getFirstName()) &&
                    Objects.equals(getLastName(), owner.getLastName()) &&
                    Objects.equals(getAddress(), owner.getAddress()) &&
                    Objects.equals(getCity(), owner.getCity()) &&
                    Objects.equals(getTelephone(), owner.getTelephone()) &&
                    Objects.equals(getPets(), owner.getPets());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getFirstName(), getLastName(), getAddress(), getCity(), getTelephone(), getPets());
        }
    }

