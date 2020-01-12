package com.automation.homework.pageobject.configuration;

public class Configuration {
    private String baseUrl;
    private static final String BASE_URL = "http://139.59.149.247:8000/petclinic";
    //private static final String BASE_URL = "http://localhost:8000/petclinic";


    public String getBaseUrl() {
        System.getProperty("baseUrl");
        return baseUrl;
    }
}
