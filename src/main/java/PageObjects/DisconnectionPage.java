package PageObjects;

import fr.zenity.appium.Enum.Direction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class DisconnectionPage extends View{

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"3\"]")
    private MobileElement myAccount;

    @AndroidFindBy(xpath="//android.widget.ImageView[@bounds=\"[837,1631][963,1757]\"]")
    private MobileElement myAccount2;

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"5\"]")
    private MobileElement disconnectBtn;


    public void disconnect() throws InterruptedException {
        longWait.until(elementToBeClickable(myAccount)).click();
        try {
            //System.out.println("myAccount= "+myAccount2.getAttribute("index"));
            myAccount2.click();
        }
        catch (Exception e){
            System.out.println("myAccount clicked");
        }
        swipeScreen(Direction.UP);
        System.out.println("before disconnectBtn ");
        System.out.println("disconnectBtn.isDisplayed? "+disconnectBtn.isDisplayed());
        longWait.until(visibilityOf(disconnectBtn)).click();
    }

}
