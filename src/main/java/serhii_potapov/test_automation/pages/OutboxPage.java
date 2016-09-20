package serhii_potapov.test_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Serhii_Potapov
 */

public class OutboxPage extends BasePage {

    public OutboxPage(WebDriver driver) {
        super(driver);
    }

    private static final String OUTBOX = "//ul[@class='list_underlined']//a[contains(@href,'sent')]";
    private static final String SENT_LETTER = "#mesgList > form > div:first-of-type";
    private static final String CONTENT_AREA = ".message_body>pre";

    @FindBy(xpath = OUTBOX)
    public WebElement outbox;

    @FindBy(css = SENT_LETTER)
    public WebElement sentLetter;

    @FindBy(css = CONTENT_AREA)
    public WebElement contentArea;

    WebElement getOutbox(){
        return outbox;
    }

    WebElement getSentLetter(){
        return sentLetter;
    }

    public WebElement getContentArea(){
        return contentArea;
    }

        public void selectSentLetter(String message){
        outbox.click();
        sentLetter.click();
    }

}