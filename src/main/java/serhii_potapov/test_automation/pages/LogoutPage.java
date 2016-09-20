package serhii_potapov.test_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Serhii_Potapov
 */

public class LogoutPage extends BasePage {

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    private static final String SETTING_BUTTON = ".icon-ho.ho_settings";
    private static final String LOGOUT_BUTTON = ".ho_popup_menu_item:last-of-type > a";

    @FindBy(css = SETTING_BUTTON)
    public WebElement settingButton;

    @FindBy(css = LOGOUT_BUTTON)
    public WebElement logoutButton;

    WebElement getSettingButton(){
        return settingButton;
    }

    WebElement getLogoutButton(){
        return logoutButton;
    }

    public void logout(){
        settingButton.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }
}