package PageObjects;

import fr.zenity.appium.Enum.Direction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class PassOrderPage extends View{

    @AndroidFindBy(xpath="//android.view.View[@index=\"1\"]")
    private MobileElement productToadd;

    @AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Ajouter au panier\"]")
    private MobileElement addoToCart;

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"4\"]")
    private MobileElement flashDeals;

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"1\"]")
    private MobileElement cartBtn;

    @AndroidFindBy(xpath="//android.widget.Button[@index=\"5\"]")
    private MobileElement validateBtn;

    @AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\"com.example.shop_app:id/et_card_number\"]")
    private MobileElement cardNbreField;

    @AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\"com.example.shop_app:id/et_expiry\"]")
    private MobileElement expirationDateField;

    @AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\"com.example.shop_app:id/et_cvc\"]")
    private MobileElement CVCField;

    @AndroidFindBy(xpath="//android.widget.Button[@index=\"1\"]")
    private MobileElement saveBtn;

    @AndroidFindBy(xpath="//android.widget.Button[@index=\"1\"]")
    private MobileElement cartConfirmed;

    @AndroidFindBy(xpath="//android.widget.TextView[@index=\"0\"]")
    private MobileElement cardErr;

    @AndroidFindBy(className="android.view.View")
    private List<MobileElement> productsList;


    public void loggedIn() {
        longWait.until(visibilityOf(flashDeals));
        assertThat(flashDeals.isDisplayed(),equalTo(true));
    }

    //check an item to an existing list
    public void clickToList(List<MobileElement> elementList, String name) throws InterruptedException {
        MobileElement aEl = elementList.stream()
                .filter(element -> element.getAttribute("content-desc").contains(name))
                .findFirst().get();

        aEl.click();
    }

    public void checkListElPresent(List<MobileElement> mEl, String name){
        mEl.forEach(
                (c) -> {

                    if(!c.getAttribute("content-desc").contains(name)){
                        try {
                            swipeScreen(Direction.LEFT);
                            clickToList(mEl, name);
                            swipeScreen(Direction.UP);
                        } catch (InterruptedException e) {
                            System.out.println("ELEMENT NOT FOUND ..........");
                            e.printStackTrace();
                        }
                    }
                }
        );
    }
    public void addProductToCart(String product) throws InterruptedException {
        MobileElement productChosen = null;
        swipeScreen(Direction.UP);
        swipeScreen(Direction.UP);

        System.out.println("any match: " + productsList.stream().anyMatch(element ->element.getAttribute("content-desc").contains(product)));
        productChosen = productsList.stream().filter(element ->element.getAttribute("content-desc").contains(product)).findFirst().get();
        System.out.println("productChosen= "+productChosen.getAttribute("content-desc"));
        productChosen.click();

        swipeScreen(Direction.UP);
        longWait.until(elementToBeClickable(addoToCart)).click();
    }

    public void confirmCart(String cardNbre,String expirationDate,String code)  {
        longWait.until(elementToBeClickable(cartBtn)).click();
        longWait.until(elementToBeClickable(validateBtn)).click();
        longWait.until(visibilityOf(cardNbreField)).sendKeys(cardNbre);
        longWait.until(visibilityOf(expirationDateField)).sendKeys(expirationDate);
        longWait.until(visibilityOf(CVCField)).sendKeys(code);
        longWait.until(elementToBeClickable(saveBtn)).click();
    }

    public void checkErrMsgCard(){
        try {
            longWait.until(ExpectedConditions.visibilityOf(cardErr));
            Assert.fail("ERROR: "+cardErr.getText());
        }
        catch (Exception e){
            System.out.println("Correct card number");
        }

    }

    public void cartCOnfirmedMeth(){
        longWait.until(visibilityOf(cartConfirmed));
        assertThat(cartConfirmed.getAttribute("content-desc"),equalTo("Ok"));
        cartConfirmed.click();
    }

}
