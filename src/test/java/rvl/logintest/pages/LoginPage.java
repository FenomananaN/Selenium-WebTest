package rvl.logintest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement emailAddressField() {
        return driver.findElement(By.id("inputEmail"));
    }

    private WebElement passwordField() {
        return driver.findElement(By.id("inputPassword"));
    }

    private WebElement loginBtn() {
        return driver.findElement(By.cssSelector("button[type='submit']"));
    }

    public void performLogin(String email, String password){
        emailAddressField().clear();
        emailAddressField().sendKeys(email);
        passwordField().clear();
        passwordField().sendKeys(password);
        loginBtn().click();
    }

    public String getErrorMessageText() {
        return driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible.position-absolute.w-100.fade.show")).getText();
    }

    public WebElement getErrorFlashElement() {
        return driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible.position-absolute.w-100.fade.show"));
    }
    
}
