package rvl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import rvl.service.Service;

import java.time.Duration;

public class FormationTest extends BaseTest {
    Service service = new Service();
    WebDriverWait wait;

    @Test
    public void testGoToFormation() {
        
        acceptCookies();
        WebElement formationButton = driver.findElement(By.xpath("/html/body/nav/div[3]/ul/li[1]/button"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(formationButton));
        formationButton.click();

        WebElement voirTousButton = driver.findElement(By.xpath("//*[@id=\"live-3807804806-0\"]/div[1]/a"));
        wait.until(ExpectedConditions.elementToBeClickable(voirTousButton));
        voirTousButton.click();
        
        service.consoleLog("Formation test finished.");
    }

    @Test
    public void testSearchFormation() {
        service.consoleLog("Debut testSearchFormation.");
        driver.get(baseUrl);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
            webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete")
        );
        acceptCookies();
        WebElement searchBox = driver.findElement(By.xpath("/html/body/nav/div[2]/div/form/div/input"));
        searchBox.sendKeys("web development");

        WebElement searchButton = driver.findElement(By.xpath("/html/body/nav/div[2]/div/form/button"));
        this.wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        service.consoleLog("END testSearchFormation.");
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
