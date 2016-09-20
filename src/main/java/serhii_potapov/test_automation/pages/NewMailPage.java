package serhii_potapov.test_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Serhii_Potapov
 */

public class NewMailPage extends BasePage {

    public NewMailPage(WebDriver driver) {
        super(driver);
    }

    private static final String DESTINATION_FIELD = "to";
    private static final String SUBJECT_FIELD = "subject";
    private static final String TEXT_MESSAGE = "text";
    private static final String SEND_BUTTON = "send";
    private static final String CONFIRMATION = ".block_confirmation > div:last-child";
    private static final String CREATE_NEW_MAIL_BUTTON = ".make_message>a";

    @FindBy(id = DESTINATION_FIELD)
    public WebElement destinationField;

    @FindBy(name = SUBJECT_FIELD)
    public WebElement subjectField;

    @FindBy(id = TEXT_MESSAGE)
    public WebElement textMessage;

    @FindBy(name = SEND_BUTTON)
    public WebElement sendButton;

    @FindBy(css = CONFIRMATION)
    public WebElement confirmation;

    @FindBy (css = CREATE_NEW_MAIL_BUTTON)
    public WebElement newEmail;

    WebElement getDestinationField(){
        return destinationField;
    }

    WebElement getSubjectField(){
        return subjectField;
    }

    WebElement getTextMessage(){
        return textMessage;
    }

    WebElement getSendButton(){
        return sendButton;
    }

    public WebElement getConfirmation(){
        return confirmation;
    }

    public WebElement getNewEmail(){
        return newEmail;
    }

    public void createNewEmail(String destination, String subject, String message){
        newEmail.click();
        destinationField.clear();
        destinationField.sendKeys(destination);
        subjectField.clear();
        subjectField.sendKeys(subject);
        textMessage.clear();
        textMessage.sendKeys(message);
        sendButton.click();
    }
}