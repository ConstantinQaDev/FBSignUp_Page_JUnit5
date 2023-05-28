package org.FaceBookPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {
    private static WebDriver webDriver;
    WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    public static WebDriver getWebDriver(){

        if(webDriver == null){
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }

    public static void closeBrowser(){

        if(webDriver != null){
            webDriver.quit();
        }
    }

    protected WebElement waitForElementVisibility(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

//    public void switchToTab(int tab) {
//
//        driver.switchTo().window(driver.getWindowHandle([tab]));
//    }
}
