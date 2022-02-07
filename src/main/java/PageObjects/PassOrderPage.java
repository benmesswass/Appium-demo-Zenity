package PageObjects;

import fr.zenity.appium.Enum.Direction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Allure;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.List;
import java.math.BigDecimal.*;


import static io.appium.java_client.touch.TapOptions.tapOptions;
import static java.lang.Math.abs;
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

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"0\"]")
    private MobileElement productInCart;

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

    @AndroidFindBy(xpath="//android.widget.FrameLayout[@index=\"0\"]")
    private MobileElement cancelCard;

    @AndroidFindBy(xpath="//android.widget.Button[@index=\"0\"]")
    private MobileElement backBtn;

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"0\"]")
    private MobileElement secondBackBtn;

    @AndroidFindBy(xpath="//android.widget.Button[@index=\"2\"]")
    private MobileElement addProductNbre;

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"1\"]")
    private MobileElement descriptionProduct;

    @AndroidFindBy(xpath="//android.view.View[@index=\"5\"]")
    private MobileElement totolPriceDisplayed;

    TouchAction touchAction = new TouchAction(driver);
    int numberInt=1;
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
    public void addProductToCart(String product, String number) throws InterruptedException {
        MobileElement productChosen = null;
        numberInt = Integer.parseInt(number);
        swipeScreen(Direction.UP);
        swipeScreen(Direction.UP);
        //System.out.println("any match: " + productsList.stream().anyMatch(element ->element.getAttribute("content-desc").contains(product)));
        productChosen = productsList.stream().filter(element ->element.getAttribute("content-desc").contains(product)).findFirst().get();
        //System.out.println("productChosen= "+productChosen.getAttribute("content-desc"));
        Float priceInt = Float.parseFloat(productChosen.getAttribute("content-desc").split("\n")[1].substring(1));
        //System.out.println("price= "+priceInt);

        productChosen.click();
        swipeScreen(Direction.UP);
        for (int i = 1; i<numberInt;i++) {
        longWait.until(elementToBeClickable(addProductNbre)).click();
        }

        longWait.until(elementToBeClickable(addoToCart)).click();
        longWait.until(elementToBeClickable(cartBtn)).click();

        Float priceCartFloat = Float.parseFloat(productInCart.getAttribute("content-desc").split("\n")[1].substring(1).split(" ")[0]);
        Float productNbreInCartFoat = Float.parseFloat(productInCart.getAttribute("content-desc").split("\n")[1].substring(1).split(" ")[1].substring(1));
        BigDecimal totalPriceRound =  BigDecimal.valueOf(priceCartFloat * productNbreInCartFoat).setScale(2, RoundingMode.FLOOR);
        Float totalPrice = totalPriceRound.floatValue();

        longWait.until(visibilityOf(totolPriceDisplayed));
        BigDecimal totalPriceDisplayedRound = BigDecimal.valueOf(Float.parseFloat(totolPriceDisplayed.getAttribute("content-desc").split("\n")[1].substring(1).split(" ")[1])).setScale(2, RoundingMode.FLOOR);
        Float totalPriceDisplayedFloat = totalPriceDisplayedRound.floatValue();
        System.out.println("#########################BEGIN#############################");
        System.out.println("priceInt= "+priceInt);
        System.out.println("priceCartFloat= "+priceCartFloat);
        System.out.println("totalPrice= "+totalPrice);
        System.out.println("totalPriceRound= "+totalPriceRound);
        System.out.println("totolPriceDisplayedFloat= "+totalPriceDisplayedFloat);
        System.out.println("totalPriceDisplayedRound= "+totalPriceDisplayedRound);
        boolean yesorno = (abs(totalPrice-totalPriceDisplayedFloat))<1;
        System.out.println("yes or no? "+yesorno);
        //System.out.println("yes or no? "+ (totalPrice ==totalPriceDisplayedFloat));

        System.out.println("#########################END#######################");

        /*Assert.assertTrue(priceInt.equals(priceCartFloat));
        Assert.assertTrue(abs(totalPrice-totalPriceDisplayedFloat)<1);*/
    }


    public void confirmCart(String cardNbre,String expirationDate,String code)  {
        longWait.until(elementToBeClickable(validateBtn)).click();
        longWait.until(visibilityOf(cardNbreField)).sendKeys(cardNbre);
        longWait.until(visibilityOf(expirationDateField)).sendKeys(expirationDate);
        longWait.until(visibilityOf(CVCField)).sendKeys(code);
        longWait.until(elementToBeClickable(saveBtn)).click();
    }

    public void checkErrMsgCard() throws InterruptedException {
        try {
            longWait.until(ExpectedConditions.visibilityOf(cardErr));
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            String cardErrMsg = cardErr.getText();
            touchAction.press(PointOption.point(200, 200))
                    .perform();
            longWait.until(elementToBeClickable(backBtn));
            backBtn.click();
            longWait.until(elementToBeClickable(secondBackBtn));
            secondBackBtn.click();
            Assert.fail("ERROR: "+cardErrMsg);
        }
        catch (Exception e){
            longWait.until(visibilityOf(cartConfirmed));
            assertThat(cartConfirmed.getAttribute("content-desc"),equalTo("Ok"));
            System.out.println("before click");
            cartConfirmed.click();
            try {
                cartConfirmed.click();
            } catch (Exception ex){
                System.out.println("clicked");
            }
        }
    }

}
