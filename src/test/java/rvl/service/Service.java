package rvl.service;

import org.openqa.selenium.WebElement;

public class Service {

    public static void showElement(WebElement searchBox) {
        System.out.println("Tag name: " + searchBox.getTagName());
        System.out.println("Type: " + searchBox.getAttribute("type"));
        System.out.println("ID: " + searchBox.getAttribute("id"));
        System.out.println("Class: " + searchBox.getAttribute("class"));
        System.out.println("Displayed: " + searchBox.isDisplayed());
        System.out.println("Enabled: " + searchBox.isEnabled());
    }

    public void consoleLog(String message) {
        System.out.println(message);
    }
    
}
