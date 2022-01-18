package PageObjects;

import fr.zenity.appium.Enum.Direction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class DisconnectionPage extends View{

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"3\"]")
    private MobileElement myAccount;

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"5\"]")
    private MobileElement disconnectBtn;


    public void disconnect() throws InterruptedException {
        longWait.until(elementToBeClickable(myAccount)).click();
        myAccount.click();
        swipeScreen(Direction.UP);
        longWait.until(elementToBeClickable(disconnectBtn)).click();
    }

}
