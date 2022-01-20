package fr.zenity.appium.stepDefinitions;

import PageObjects.PassOrderPage;
import io.cucumber.java8.En;

public class PassOrderSteps implements En {

    public PassOrderSteps(PassOrderPage passOrderPage) {

        Given("^user is connected to his account with his \"([^\"]*)\" and his \"([^\"]*)\"$", (String mail, String password) -> {
            passOrderPage.clickOnContinue();
            passOrderPage.ConnectionPageVerif();
            passOrderPage.enterCredentials(mail,password);
            passOrderPage.loggedIn();
        });

        When("^user wants to add products to his cart$", () -> {
            passOrderPage.addProductToCart();
        });
        Then("^user should be able to confirm his order using his card information: \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$", (String cardNbre, String expirationDate, String code) -> {
            passOrderPage.confirmCart(cardNbre, expirationDate, code);
        });

    }
}
