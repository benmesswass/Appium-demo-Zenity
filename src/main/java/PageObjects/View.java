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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public abstract class View {

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
