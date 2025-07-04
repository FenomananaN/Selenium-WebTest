package rvl.logintest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterTest
    public void tearDown() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
        if (driver != null) {
            driver.quit();
        }
    }

    public void takeScreenshot(String pathname) throws IOException {
       // Full Page screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File trg = new File(".\\screenshots\\" + pathname + ".png");
        FileUtils.copyFile(src, trg);
    }

    public void takeScreenshot(WebElement we,String pathname) throws IOException {
        // Full Page screenshot
         TakesScreenshot ts = (TakesScreenshot) we;
         File src = ts.getScreenshotAs(OutputType.FILE);
         File trg = new File(".\\screenshots\\" + pathname + ".png");
         FileUtils.copyFile(src, trg);
     }
}