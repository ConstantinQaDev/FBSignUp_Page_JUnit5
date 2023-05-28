package org.FaceBookPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    protected WebDriver Driver;

    public PageBase(WebDriver driver)
    {
        Driver = driver;
        PageFactory.initElements(driver, this);
    }
}
