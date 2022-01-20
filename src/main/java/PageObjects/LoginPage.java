package PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage extends View{

    @AndroidFindBy(xpath="//android.view.View[@index=\"9\"]")
    private MobileElement connectionPage;

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"0\"]")
    private MobileElement mailField;

    @AndroidFindBy(xpath="//android.widget.EditText[@index=\"1\"]")
    private MobileElement passwordField;

    @AndroidFindBy(xpath="//android.widget.Button[@index=\"5\"]")
    private MobileElement continueBtn;

    @AndroidFindBy(xpath="//android.widget.Button[@index=\"3\"]")
    private MobileElement registrationSuccessMsg;

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"4\"]")
    private MobileElement flashDeals;

    @AndroidFindBy(xpath="//android.widget.Button[1]")
    private MobileElement isOK;
/*
    public void clickOnContinue(){
        shortWait.until(elementToBeClickable(isOK)).click();
    }

    public void ConnectionPageVerif() {
        longWait.until(visibilityOf(connectionPage));
        assertThat(connectionPage.isDisplayed(),equalTo(true));
    }

    public  void enterCredentials(String mail, String password) {
        shortWait.until(elementToBeClickable(mailField)).click();
        mailField.click();
        mailField.sendKeys(mail);

        shortWait.until(elementToBeClickable(passwordField)).click();
        passwordField.click();
        passwordField.sendKeys(password);

        longWait.until(elementToBeClickable(continueBtn)).click();
        longWait.until(elementToBeClickable(registrationSuccessMsg)).click();
    }

    public void loggedIn() {
        longWait.until(visibilityOf(flashDeals));
        assertThat(flashDeals.isDisplayed(),equalTo(true));
    }

 */
}
