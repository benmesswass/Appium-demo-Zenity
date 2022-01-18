package PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class RegistrationPage extends View{

    @AndroidFindBy(xpath="//android.widget.Button[1]")
    private MobileElement isOK;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"S'inscrire\"]")
    private MobileElement registerButton;

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"2\"]")
    private MobileElement mailField;

    @AndroidFindBy(xpath="//android.widget.EditText[@index=\"3\"]")
    private MobileElement passwordField;

    @AndroidFindBy(xpath="//android.widget.EditText[@index=\"4\"]")
    private MobileElement confirmPasswordField;

    @AndroidFindBy(xpath="//android.widget.Button[@index=\"5\"]")
    private MobileElement continueBtn;

    @AndroidFindBy(xpath="//android.widget.Button[@index=\"3\"]")
    private MobileElement registrationSuccessMsg;

    public boolean applicationOk(){
        longWait.until(visibilityOf(isOK));
        return true;
    }

    public void clickOnContinue(){
        shortWait.until(elementToBeClickable(isOK)).click();
    }

    public void clickOnRegistered() {
        longWait.until(elementToBeClickable(registerButton)).click();
    }

    public  void enterCredentials(String mail, String password) {
        shortWait.until(elementToBeClickable(mailField)).click();
        mailField.click();
        mailField.sendKeys(mail);

        shortWait.until(elementToBeClickable(passwordField)).click();
        passwordField.click();
        passwordField.sendKeys(password);

        shortWait.until(elementToBeClickable(confirmPasswordField)).click();
        confirmPasswordField.click();
        confirmPasswordField.sendKeys(password);

        longWait.until(elementToBeClickable(continueBtn)).click();
    }

    public void registrationConfirmation()  {
        longWait.until(elementToBeClickable(registrationSuccessMsg));
        assertThat(registrationSuccessMsg.isDisplayed(),equalTo(true));
        registrationSuccessMsg.click();
    }


}
