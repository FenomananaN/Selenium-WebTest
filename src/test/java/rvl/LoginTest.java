package rvl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import rvl.service.Service;

import java.time.Duration;

public class LoginTest extends BaseTest {
    Service service = new Service();
    WebDriverWait wait;

    @Test
    public void loginToadmin() {
        
        driver.get(baseUrl+ "login");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
            webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete")
        );
        acceptCookies();
        driver.findElement(By.id("inputEmail")).sendKeys("test_admin@gmail.com");
        driver.findElement(By.id("inputPassword")).sendKeys("tatata");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();

        WebElement navigationToggler = driver.findElement(By.id("navigation-toggler"));
        wait.until(ExpectedConditions.elementToBeClickable(navigationToggler));
        navigationToggler.click();
        
        WebElement adminPanelLink = driver.findElement(By.xpath("/html/body/div[1]/div[2]/aside/nav/ul/li[6]/a"));
        wait.until(ExpectedConditions.elementToBeClickable(adminPanelLink));
        adminPanelLink.click();
        
        service.consoleLog("Formation test finished.");
    }
   

    public void acceptCookies() {
        if (driver.findElements(By.id("agreeAllCookieBtn")).size() > 0) {
            WebElement acceptCookiesButton = driver.findElement(By.id("agreeAllCookieBtn"));
            acceptCookiesButton.click();
            service.consoleLog("Cookies accepted.");
        } else {
            service.consoleLog("No cookies button found.");
        }
    }
}
