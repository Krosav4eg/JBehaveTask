package serhii_potapov.test_automation.pages.steps;

import serhii_potapov.test_automation.pages.factory.DriverFactory;
import serhii_potapov.test_automation.pages.LoginPage;
import serhii_potapov.test_automation.pages.LogoutPage;
import serhii_potapov.test_automation.pages.NewMailPage;
import serhii_potapov.test_automation.pages.OutboxPage;
import org.jbehave.core.annotations.*;
import org.openqa.selenium.WebDriver;

import static serhii_potapov.test_automation.pages.factory.DriverFactory.getDriver;
import static org.junit.Assert.assertTrue;

/**
 * Created by Serhii_Potapov
 */

public class EmailSteps {

    private static final String URL = "http://www.i.ua/";
    private DriverFactory factory;
    private WebDriver driver;
    private LoginPage loginPage;
    private LogoutPage logoutPage;
    private NewMailPage newMailPage;
    private OutboxPage outboxPage;

    @BeforeStory
    public void setUp() {
        driver = getDriver("Opera");
        driver.manage().window().maximize();
    }

    @Given("I launch http://www.i.ua/ page")
    public void launchMailServicePage() {
        driver.get(URL);
    }

    @When("I enter <Email> in the field \"Логин\" and <Password> in the field \"Пароль\", then click on button \"Войти\"")
    public void loginIntoEmail(@Named("Email") String email, @Named("Password") String password) {
        loginPage = new LoginPage(driver);
        loginPage.loginIntoEmail(email, password);
    }

    @Then("I create new letter and send it to <Destination> with <Subject> and <Message>")
    public void sendLetter(@Named("Destination") String destination, @Named("Subject") String subject,
                            @Named("Message") String message) {
        newMailPage = new NewMailPage(driver);
        newMailPage.createNewEmail(destination, subject, message);
        assertTrue("The letter was not sent", newMailPage.getConfirmation().isDisplayed());
    }

    @Then("I verify that letter was sent successfully with the proper content")
    public void verifySentLetter(@Named("Message") String message) {
        outboxPage = new OutboxPage(driver);
        outboxPage.selectSentLetter(message);
        assertTrue("The text letter is not match", outboxPage.getContentArea().getText().contains(message));
    }

    @Then("I logout from the Email")
    public void logoutFromEmail() {
        logoutPage = new LogoutPage(driver);
        logoutPage.logout();
    }

    @AfterStory
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}