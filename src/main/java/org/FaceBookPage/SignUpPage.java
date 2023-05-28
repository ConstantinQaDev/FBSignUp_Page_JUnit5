package org.FaceBookPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class SignUpPage extends PageBase{
    public SignUpPage(WebDriver driver){
        super(driver);
    }
    @FindBy(how = How.XPATH, using = "//*[text()='Create new account']")
    public WebElement createNewAccountField;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Sign Up')]")
    public WebElement signUpWindow;

    @FindBy(how = How.XPATH, using = "//*[@name='websubmit']")
    public WebElement signUpButtonField;

    @FindBy(how = How.XPATH, using = "//input[@name='firstname']")
    public WebElement firstNameField;

    @FindBy(how = How.XPATH, using = "//input[@name='lastname']")
    public WebElement lastNameField;

    @FindBy(how = How.XPATH, using = "//*[@aria-label='Mobile number or email']")
    public WebElement mobileNumberOrEmailField;

    @FindBy(how = How.XPATH, using = "//input[@name='reg_passwd__']")
    public WebElement newPasswordField;

    @FindBy(how = How.XPATH, using = "//*[@title='Month']")
    public WebElement monthDropDownList;

    @FindBy(how = How.XPATH, using = "//*[@title='Day']")
    public WebElement dayDropDownList;

    @FindBy(how = How.XPATH, using = "//*[@title='Year']")
    public WebElement yearDropDownList;

    @FindBy(how = How.XPATH, using = "//*[text()='Female']//following-sibling::*[@type='radio']")
    public WebElement genderFemaleRadioButton;

    @FindBy(how = How.XPATH, using = "//*[text()='Male']//following-sibling::*[@type='radio']")
    public WebElement genderMaleRadioButton;

    @FindBy(how = How.XPATH, using = "//a[@id='terms-link']")
    public WebElement termsLink;

    @FindBy(how = How.XPATH, using = "//a[@id='privacy-link']")
    public WebElement privacyPolicyLink;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'your name?')]")
    public WebElement whatsYourNameErrorMessage;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'your name?')]")
    public WebElement whatsYourLastNameErrorMessage;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'to reset')]")
    public WebElement mobileOrEmailErrorMessage;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'six numbers')]")
    public WebElement newPasswordErrorMessage;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'real birthday')]")
    public WebElement birthDayErrorMessage;
}