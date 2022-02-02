package PageObjects;

import fr.zenity.appium.manager.ManagerXLS;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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

    @AndroidFindBy(xpath="//android.widget.Button[@index=\"7\"]")
    private MobileElement continueBtnCharging;

    /*@AndroidFindBy(xpath="//android.view.View[@index=\"6\"]")
    private MobileElement errorMailMsg;*/

    public boolean applicationOk(){
        longWait.until(visibilityOf(isOK));
        return true;
    }

    public List<String> testXLS(int line){
        System.out.println("before user from file= user");

        ManagerXLS data = new ManagerXLS();
        data.load("Registration");
        List<String> user = data.getLine(line);
        return user;
    }

    public void clickOnContinue(){
        shortWait.until(elementToBeClickable(isOK)).click();
    }

    public void clickOnRegistered() {
        try{
        longWait.until(elementToBeClickable(registerButton)).click();
        }
        catch (Exception e){
            System.out.println("Already in registration page");
        }
    }

    public  void enterCredentialsRegistration(String mail, String password, String confirmPassword) {

            shortWait.until(elementToBeClickable(mailField)).click();
            mailField.click();
            mailField.sendKeys(mail);
            shortWait.until(elementToBeClickable(passwordField)).click();
            passwordField.click();
            passwordField.sendKeys(password);
            shortWait.until(elementToBeClickable(confirmPasswordField)).click();
            confirmPasswordField.click();
            confirmPasswordField.sendKeys(confirmPassword);

    }

    public void submit(){
        try{
            continueBtn.click();
        }
        catch(Exception e){
        continueBtnCharging.click();
         }
    }

}
