package org.FaceBookPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PageWait {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public PageWait(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }
    protected WebElement waitForElementVisibility(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}
