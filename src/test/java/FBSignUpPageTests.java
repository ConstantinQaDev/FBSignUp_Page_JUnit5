import org.FaceBookPage.SignUpPage;
import org.FaceBookPage.TestBase;
import static org.FaceBookPage.Constants.FACEBOOK_HOME_PAGE_URL;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FBSignUpPageTests extends TestBase {

    private static WebDriver driver;
    private static SignUpPage locators;
    static WebDriverWait wait;

    @BeforeAll
    public static void classSetUp(){
        driver = getWebDriver();
        driver.get(FACEBOOK_HOME_PAGE_URL);

        locators = new SignUpPage(driver);

        WebElement createNewAccountElement = locators.createNewAccountField;
        assertNotNull(createNewAccountElement);
        createNewAccountElement.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(locators.signUpWindow));
    }

    @AfterAll
    public static void classTearDown(){
        TestBase.closeBrowser();
    }

    @Test
    public void createNewAccountButtonTest()  {
        wait.until(ExpectedConditions.visibilityOf(locators.signUpButtonField));

        WebElement signUpButtonElement = locators.signUpButtonField;
        assertNotNull(signUpButtonElement);
        signUpButtonElement.click();
    }

    @Test
    public void errorMessagesForEmptyFieldsTest() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(locators.signUpWindow));

        WebElement signUpButtonElement = locators.signUpButtonField;
        assertNotNull(signUpButtonElement);
        signUpButtonElement.click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='age_to_birthday_link']")).click();
        assertNotNull(driver.findElement(By.xpath("//*[@id='age_to_birthday_link']")));
        Thread.sleep(2000);

        WebElement firstNameElementErrorMessage = locators.firstNameField;
        firstNameElementErrorMessage.click();
        assertNotNull(firstNameElementErrorMessage);
        WebElement whatsYourNameError = locators.whatsYourNameErrorMessage;
        assertNotNull(whatsYourNameError);
        Thread.sleep(2000);

        WebElement lastNameElement = locators.lastNameField;
        lastNameElement.click();
        assertNotNull(lastNameElement);
        WebElement whatsYourLastNameError = locators.whatsYourLastNameErrorMessage;
        assertNotNull(whatsYourLastNameError);
        Thread.sleep(2000);

        WebElement mobileNumberOrEmailElement = locators.mobileNumberOrEmailField;
        mobileNumberOrEmailElement.click();
        assertNotNull(mobileNumberOrEmailElement);
        WebElement mobileOrEmailError = locators.mobileOrEmailErrorMessage;
        assertNotNull(mobileOrEmailError);
        Thread.sleep(2000);

        WebElement newPasswordElement = locators.newPasswordField;
        newPasswordElement.click();
        assertNotNull(newPasswordElement);
        WebElement newPasswordError = locators.newPasswordErrorMessage;
        assertNotNull(newPasswordError);
        Thread.sleep(2000);

        WebElement monthDropDownListElement = locators.monthDropDownList;
        monthDropDownListElement.click();
        assertNotNull(monthDropDownListElement);
        WebElement birthDayError = locators.birthDayErrorMessage;
        assertNotNull(birthDayError);
        Thread.sleep(2000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1905", "1950", "2023"})
    public void yearTestParameterized(String yearInput) throws InterruptedException {

        driver.findElement(By.xpath("//*[@title='Year']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='"+ yearInput +"']")).click();
        Thread.sleep(2000);

        String yearValue = driver.findElement(By.xpath("//*[@title='Year']")).getAttribute("value");
        assertEquals(yearInput, yearValue);
        Thread.sleep(2000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Sep", "Oct", "Nov"})
    public void monthTestParameterized(String monthInput){

        WebElement monthDropDownListElement4 = locators.monthDropDownList;
        wait.until(ExpectedConditions.elementToBeClickable(monthDropDownListElement4));
        monthDropDownListElement4.click();
        assertNotNull(monthDropDownListElement4);

        driver.findElement(By.xpath("//*[text()='"+ monthInput +"']")).click();

        WebElement selectedOption = new Select(monthDropDownListElement4).getFirstSelectedOption();
        String monthValue = selectedOption.getText();

        assertEquals(monthInput, monthValue);
    }

    @Test
    public void setMonthExampleTest() throws InterruptedException {

        WebElement monthDropDownListElement = locators.monthDropDownList;
        wait.until(ExpectedConditions.elementToBeClickable(monthDropDownListElement));
        monthDropDownListElement.click();
        assertNotNull(monthDropDownListElement);

        Select monthSelect = new Select(monthDropDownListElement);
        monthSelect.selectByVisibleText("Apr");
        String selectedMonth = monthSelect.getFirstSelectedOption().getText();
        assertEquals("Apr", selectedMonth);
        Thread.sleep(2000);

        WebElement monthDropDownListElement2 = locators.monthDropDownList;
        wait.until(ExpectedConditions.elementToBeClickable(monthDropDownListElement2));
        monthDropDownListElement2.click();
        assertNotNull(monthDropDownListElement2);

        monthSelect.selectByVisibleText("Aug");
        String selectedMonth2 = monthSelect.getFirstSelectedOption().getText();
        assertEquals("Aug", selectedMonth2);
        Thread.sleep(2000);

        WebElement monthDropDownListElement3 = locators.monthDropDownList;
        wait.until(ExpectedConditions.elementToBeClickable(monthDropDownListElement3));
        monthDropDownListElement3.click();
        assertNotNull(monthDropDownListElement3);

        monthSelect.selectByVisibleText("Dec");
        String selectedMonth3 = monthSelect.getFirstSelectedOption().getText();
        assertEquals("Dec", selectedMonth3);
        Thread.sleep(2000);
    }

    @Test
    public void radioButtonsTest()  {
        wait.until(ExpectedConditions.elementToBeClickable(locators.genderFemaleRadioButton));

        WebElement genderFemaleRadioButtonElement = locators.genderFemaleRadioButton;
        wait.until(ExpectedConditions.elementToBeClickable(locators.genderFemaleRadioButton));
        genderFemaleRadioButtonElement.click();
        assertNotNull(genderFemaleRadioButtonElement);

        WebElement genderMaleRadioButtonElement = locators.genderMaleRadioButton;
        wait.until(ExpectedConditions.elementToBeClickable(locators.genderMaleRadioButton));
        genderMaleRadioButtonElement.click();
        assertNotNull(genderMaleRadioButtonElement);
    }

    @Test
    public void termsLinkTest() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.termsLink));

        WebElement termsLinkElement = locators.termsLink;
        wait.until(ExpectedConditions.elementToBeClickable(locators.termsLink));
        termsLinkElement.click();
        assertNotNull(termsLinkElement);

        for (String windowHandle1 : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle1);
        }
        String newTermsPageURL = driver.getCurrentUrl();
        assertEquals("https://www.facebook.com/legal/terms/update", newTermsPageURL);

        driver.switchTo().window(driver.getWindowHandles().iterator().next());
    }

    @Test
    public void PrivacyPolicyLinkTest()  {
        wait.until(ExpectedConditions.elementToBeClickable(locators.privacyPolicyLink));

        WebElement privacyPolicyLinkElement = locators.privacyPolicyLink;
        wait.until(ExpectedConditions.elementToBeClickable(locators.privacyPolicyLink));
        privacyPolicyLinkElement.click();
        assertNotNull(privacyPolicyLinkElement);

        for(String windowHandle2 : driver.getWindowHandles()){
            driver.switchTo().window(windowHandle2);
        }
        String newPrivacyPolicyPageURL = driver.getCurrentUrl();
        assertEquals("https://www.facebook.com/privacy/policy/?entry_point=data_policy_redirect&entry=0", newPrivacyPolicyPageURL);

        driver.switchTo().window(driver.getWindowHandles().iterator().next());
    }
}
