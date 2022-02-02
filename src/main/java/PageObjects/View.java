package PageObjects;

import fr.zenity.appium.Enum.Direction;
import fr.zenity.appium.drivers.MobileDriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.SplittableRandom;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public abstract class View {

    @AndroidFindBy(xpath="//android.view.View[@index=\"1\"]")
    private MobileElement connectionPage;

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"1\"]")
    private List<MobileElement> homePageDisplayed;

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"0\"]")
    private MobileElement mailField;

    @AndroidFindBy(xpath="//android.widget.EditText[@index=\"1\"]")
    private MobileElement passwordField;

    @AndroidFindBy(xpath="//android.widget.Button[@index=\"5\"]")
    private MobileElement continueBtn;

    @AndroidFindBy(xpath="//android.widget.Button[@index=\"7\"]")
    private MobileElement continueBtnCharging;

    @AndroidFindBy(xpath="//android.widget.Button[@index=\"3\"]")
    private MobileElement registrationSuccessMsg;

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"4\"]")
    private MobileElement flashDeals;

    @AndroidFindBy(xpath="//android.widget.Button[@index=\"1\"]")
    private MobileElement isOK;

    /*@AndroidFindBy(xpath="//android.view.View[@index=\"2\"]")
    private MobileElement passwordIncorrect;*/

    @AndroidFindBy(xpath="//android.view.View[@content-desc=\"Email ou Mot de passe incorrect\"]")
    private MobileElement passwordIncorrect;

    @AndroidFindBy(xpath="//android.view.View[@index=\"6\"]")
    private MobileElement errorMailMsg;

    @AndroidFindBy(xpath="//android.view.View[@bounds=\"[127,1280][657,1335]\"]")
    private MobileElement errorMailMsgReg;

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"3\"]")
    private MobileElement myAccount;

    protected AppiumDriver<MobileElement> driver;

    protected WebDriverWait wait;
    protected WebDriverWait shortWait;
    protected WebDriverWait middleWait;
    protected WebDriverWait longWait;

    protected View (){
        driver = MobileDriverManager
                .getInstance()
                .getDriver()
                .getDriver();

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        wait        = new WebDriverWait(driver, 5);
        shortWait   = new WebDriverWait(driver, 10);
        middleWait  = new WebDriverWait(driver, 20);
        longWait    = new WebDriverWait(driver, 6);

    }

    /*public boolean applicationOk(){
        longWait.until(visibilityOf(isOK));
        return true;
    }*/

    public void clickOnContinue(){
        shortWait.until(elementToBeClickable(isOK)).click();
    }

    public void loginPageVerif(){
        try {
            longWait.until(visibilityOf(connectionPage));
        }
        catch (Exception e) {
            Assert.assertTrue("Oops ! The login page is now displayed.", connectionPage.isDisplayed());
        }
    }

    public void homePageVerif() {
        //longWait.until(visibilityOf(myAccount));
        System.out.println("homePageDisplayed.isDisplayed(): "+homePageDisplayed.size());
        if (homePageDisplayed.size() == 0){
            Assert.fail("Oops ! HomePage not displayed!");
        }
    }

    public  void enterCredentialsLogin(String mail, String password) {
        shortWait.until(visibilityOf(mailField)).click();
        //mailField.click();
        mailField.sendKeys(mail);
        shortWait.until(visibilityOf(passwordField)).click();
        //passwordField.click();
        passwordField.sendKeys(password);
        try {
            continueBtn.click();
        }
        catch(Exception e){
            continueBtnCharging.click();
        }
    }

    public  void deleteCredentialsLogin() {
        shortWait.until(elementToBeClickable(mailField)).click();
        mailField.clear();
        shortWait.until(elementToBeClickable(passwordField)).click();
        passwordField.clear();
    }

        public void successMsgClick(String mail, String password) {
            String newLine = System.getProperty("line.separator");
            try {
            System.out.println("in successMsgClick try block");
            longWait.until(elementToBeClickable(registrationSuccessMsg));
            registrationSuccessMsg.click();
            System.out.println("homePageDisplayed.isDisplayed(): "+homePageDisplayed.size());
            if (homePageDisplayed.size() == 0) {
                Assert.fail("Oops ! HomePage not displayed!");
            }
        } catch (Exception e) {
            Assert.fail("invalid credentials !"+ newLine+"email: "+mail+newLine+"password: "+password);
        }
    }

    public void checkErrorMsg(String mail, String password ){
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMailMsg));
            deleteCredentialsLogin();
            Assert.fail("invalid credentials:  \n mail: "+mail+"\n password: "+ password+"\n "+errorMailMsg.getAttribute("content-desc"));
        }
        catch(Exception e){
            System.out.println("---valid credentials: mail: "+mail+", password: "+ password);
        }
    }

    public void checkErrorMsg2(String mail, String password ) {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordIncorrect));
            Assert.fail("invalid credentials:  \n mail: "+mail+"\n password: "+ password+"\n "+passwordIncorrect.getAttribute("content-desc"));
        }
        catch(Exception e){
            System.out.println("---valid credentials: mail: "+mail+", password: "+ password);
        }
    }

    public void checkErrorMsgRegistration(String mail, String password ){
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMailMsgReg));
            deleteCredentialsLogin();
            Assert.fail("invalid credentials:  \n mail: "+mail+"\n password: "+ password+"\n "+errorMailMsgReg.getAttribute("content-desc"));
        }
        catch(Exception e){
            System.out.println("---valid credentials: mail: "+mail+", password: "+ password);
        }
    }

    /*public MobileElement searchElement(List<MobileElement> listProducts, String element){
        MobileElement productChosen = null;
        System.out.println("product= "+element);
        System.out.println("listProducts.size()= "+listProducts.size());

        for (int i=0; i<listProducts.size();i++){
            //System.out.println("listProducts= "+listProducts.get(i).getAttribute("content-desc")+", index is: "+i);
            //System.out.println("yes or no: "+listProducts.get(i).getAttribute("content-desc").contains(element));

            if (listProducts.get(i).getAttribute("content-desc").contains(element)){
                productChosen = listProducts.get(i);
              //  System.out.println("----productChosen in if----"+productChosen.getAttribute("content-desc"));
            }
            System.out.println("----productChosen in for: "+productChosen.getAttribute("content-desc"));
        }
        System.out.println("----productChosen out of if---");
        System.out.println("----productChosen out of if----"+productChosen);
        return productChosen;
    }*/


    /**
     * Performs swipe from the center of screen
     *
     * @param dir the direction of swipe
     * @version java-client: 7.3.0
     **/
    public void swipeScreen(Direction dir) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

}
