package fr.zenity.appium.stepDefinitions;

import PageObjects.PassOrderPage;
import io.cucumber.java8.En;

public class PassOrderSteps implements En {

    public PassOrderSteps(PassOrderPage passOrderPage) {

        When("^user wants to add a specified \"([^\"]*)\" to his cart$", (String product) -> {
            passOrderPage.addProductToCart(product);
        });

        Then("^user should be able to confirm his order using his card information: \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$", (String cardNbre, String expirationDate, String code) -> {
            passOrderPage.confirmCart(cardNbre, expirationDate, code);
            passOrderPage.checkErrMsgCard();
            //passOrderPage.cartCOnfirmedMeth();
            //passOrderPage.homePageVerif();
        });


    }
}
