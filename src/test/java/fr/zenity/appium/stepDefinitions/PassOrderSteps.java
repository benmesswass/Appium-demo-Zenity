package fr.zenity.appium.stepDefinitions;

import PageObjects.PassOrderPage;
import io.cucumber.java8.En;

public class PassOrderSteps implements En {

    public PassOrderSteps(PassOrderPage passOrderPage) {

        Given("^user is connected to his account with his \"([^\"]*)\" and his \"([^\"]*)\"$", (String mail, String password) -> {
            passOrderPage.clickOnContinue();
            passOrderPage.loginPageVerif();
            passOrderPage.enterCredentialsLogin(mail,password);
            passOrderPage.checkErrorMsg(mail,password);
            passOrderPage.checkErrorMsg2(mail,password);
            passOrderPage.successMsgClick();
            passOrderPage.loggedIn();
        });

        When("^user wants to add a specified \"([^\"]*)\" to his cart$", (String product) -> {
            passOrderPage.addProductToCart(product);
        });

        Then("^user should be able to confirm his order using his card information: \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$", (String cardNbre, String expirationDate, String code) -> {
            passOrderPage.confirmCart(cardNbre, expirationDate, code);
            System.out.println("---checkErrCar--IN--");
            passOrderPage.checkErrMsgCard();
            System.out.println("---checkErrCar--OUT--");
            passOrderPage.cartCOnfirmedMeth();
        });


    }
}
