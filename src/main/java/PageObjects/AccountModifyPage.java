package PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;

import java.nio.charset.StandardCharsets;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AccountModifyPage extends View{

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"3\"]")
    private MobileElement myAccount;

    @AndroidFindBy(xpath="//android.widget.ImageView[@content-desc=\"Mon compte\"]")
    private MobileElement myAccount2;

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"1\"]")
    private MobileElement firstName;

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"2\"]")
    private MobileElement lastName;

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"3\"]")
    private MobileElement mobileNbre;

    @AndroidFindBy(xpath="//android.widget.ImageView[@index=\"4\"]")
    private MobileElement adress;

    @AndroidFindBy(xpath="//android.widget.Button[@index=\"5\"]")
    private MobileElement modifyBtn;

    @AndroidFindBy(xpath="//android.view.View[@index=\"0\"]")
    private MobileElement sucessMsg;

    @AndroidFindBy(xpath="//android.widget.Button[@index=\"1\"]")
    private MobileElement okBtn;

    @AndroidFindBy(xpath="//android.widget.Button[@index=\"0\"]")
    private MobileElement backBtn;

    /*public void oneFieldModif(String fieldName, String fieldInput){
        switch (fieldName){
            case "firstName":
                longWait.until(elementToBeClickable(firstName)).click();
                firstName.sendKeys(fieldInput);
                break;
            case "lastName":
                longWait.until(elementToBeClickable(lastName)).click();
                lastName.sendKeys(fieldInput);
                break;
            case "mobileNbre":
                longWait.until(elementToBeClickable(mobileNbre)).click();
                mobileNbre.sendKeys(fieldInput);
                break;
            case "adress":
                longWait.until(elementToBeClickable(adress)).click();
                adress.sendKeys(fieldInput);
                break;
            default:
                System.out.println("----nothing was done----");
                break;
        }

    }*/

    public void accountModify(String firstNameIn, String lastNameIn, String mobileNbreIn, String adressIn) throws InterruptedException {

        longWait.until(elementToBeClickable(myAccount)).click();
        longWait.until(elementToBeClickable(myAccount2)).click();

        longWait.until(visibilityOf(firstName)).click();
        firstName.sendKeys(firstNameIn);

        longWait.until(visibilityOf(lastName)).click();
        lastName.sendKeys(lastNameIn);

        longWait.until(visibilityOf(mobileNbre)).click();
        mobileNbre.sendKeys(mobileNbreIn);

        longWait.until(visibilityOf(adress)).click();
        adress.sendKeys(adressIn);

        longWait.until(visibilityOf(modifyBtn)).click();

        longWait.until(elementToBeClickable(okBtn)).click();
        longWait.until(visibilityOf(backBtn)).click();
        longWait.until(elementToBeClickable(myAccount2)).click();


    }
    public void accountModifVerif(String firstNameIn, String lastNameIn, String mobileNbreIn, String adressIn) throws InterruptedException {

        longWait.until(visibilityOf(firstName)).click();
        System.out.println("firstName.getAttribute(\"text\")= "+firstName.getAttribute("text"));
        System.out.println(firstNameIn+", First Name\n"+firstNameIn);
        Assert.assertTrue(firstName.getAttribute("text").equals(firstNameIn+", First Name\n"+firstNameIn));

        longWait.until(visibilityOf(lastName)).click();
        System.out.println("lastName.getAttribute(\"text\")= "+lastName.getAttribute("text"));
        System.out.println("Last Name\n"+lastNameIn);
        Assert.assertTrue(lastName.getAttribute("text").equals("Last Name\n"+lastNameIn));

        longWait.until(visibilityOf(mobileNbre)).click();
        Assert.assertTrue(mobileNbre.getAttribute("text").equals("Phone Number\n"+mobileNbreIn));

        longWait.until(visibilityOf(adress)).click();
        System.out.println("adress.getAttribute(\"text\")= "+adress.getAttribute("text"));
        System.out.println("Adresse\n"+adressIn);
        Assert.assertTrue(adress.getAttribute("text").equals("Adresse\n"+adressIn));
    }


    }
