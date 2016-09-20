package serhii_potapov.test_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Serhii_Potapov
 */

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final String LOGIN_FIELD = "login";
    private static final String PASSWORD_FIELD = "pass";
    private static final String AUTHORIZATION_BUTTON = ".content.clear>form>p>input";


    @FindBy(name= LOGIN_FIELD)
    private WebElement loginField;

    @FindBy(name = PASSWORD_FIELD)
    private WebElement passwordField;

    @FindBy(css = AUTHORIZATION_BUTTON)
    private WebElement authorizationButton;

    public WebElement getLoginField() {
        return loginField;
    }

    public WebElement getPasswordField(){
        return passwordField;
    }

    public WebElement getLoginButton(){
        return authorizationButton;
    }

    public void loginIntoEmail(String email, String password){
        loginField.clear();
        loginField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        authorizationButton.click();
    }
}